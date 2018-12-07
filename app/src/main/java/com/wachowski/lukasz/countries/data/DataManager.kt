package com.wachowski.lukasz.countries.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.util.Log
import com.firebase.jobdispatcher.*
import com.wachowski.lukasz.countries.data.local.ModelDao
import com.wachowski.lukasz.countries.data.remote.ApiHelper
import com.wachowski.lukasz.countries.utils.Constants.DATA_TAG
import com.wachowski.lukasz.countries.utils.Constants.PREFS_INITIALIZED
import com.wachowski.lukasz.countries.utils.Constants.PREFS_NAME
import com.wachowski.lukasz.countries.utils.Constants.SYNC_FLEXTIME_SECONDS
import com.wachowski.lukasz.countries.utils.Constants.SYNC_INTERVAL_SECONDS
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

class DataManager(private val apiHelper: ApiHelper, val modelDao: ModelDao, val context: Context) {

    fun initializeData() {

        val preferences = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)

        Log.d("Debugger", preferences.getBoolean("initialized", false).toString())

        if (preferences.getBoolean(PREFS_INITIALIZED, false)) {
            return
        }

        Completable.fromAction { this.startFetchService() }
            .subscribeOn(Schedulers.io())
            .subscribe()

        scheduleRecurringFetchDataSync()

        val editor = preferences.edit()
        editor.putBoolean(PREFS_INITIALIZED, true)
        editor.apply()
    }

    private fun startFetchService() {
        val intent = Intent(context, DataSyncIntentService::class.java)
        context.startService(intent)
    }

    private fun scheduleRecurringFetchDataSync() {
        val driver = GooglePlayDriver(context)
        val dispatcher = FirebaseJobDispatcher(driver)

        val syncJob = dispatcher.newJobBuilder()
            .setService(DataJobService::class.java)
            .setTag(DATA_TAG)
            .setConstraints(Constraint.ON_ANY_NETWORK)
            .setLifetime(Lifetime.FOREVER)
            .setRecurring(true)
            .setTrigger(
                Trigger.executionWindow(
                    SYNC_INTERVAL_SECONDS,
                    SYNC_INTERVAL_SECONDS + SYNC_FLEXTIME_SECONDS
                )
            ).setReplaceCurrent(true)
            .build()

        dispatcher.schedule(syncJob)
    }

    fun syncData() {
        apiHelper.data
            .subscribeOn(Schedulers.io())
            .flatMapCompletable { data ->
                Completable.create {

                    modelDao.insertCountries(data)

                }
            }.subscribe()


        apiHelper.data
            .subscribeOn(Schedulers.io())
            .concatMap { Flowable.fromIterable(it) }
            .concatMap { apiHelper.currencyData(it.countryName) }
            .flatMapCompletable { data ->
                Completable.create {

                    modelDao.insertCurrencies(data)
                }
            }.subscribe()
    }
}