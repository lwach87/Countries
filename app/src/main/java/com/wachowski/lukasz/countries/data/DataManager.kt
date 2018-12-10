package com.wachowski.lukasz.countries.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.support.annotation.NonNull
import android.widget.Toast
import com.firebase.jobdispatcher.*
import com.wachowski.lukasz.countries.data.local.ModelDao
import com.wachowski.lukasz.countries.data.remote.ApiHelper
import com.wachowski.lukasz.countries.utils.Constants.DATA_TAG
import com.wachowski.lukasz.countries.utils.Constants.PREFS_INITIALIZED
import com.wachowski.lukasz.countries.utils.Constants.PREFS_NAME
import com.wachowski.lukasz.countries.utils.Constants.SYNC_FLEXTIME_SECONDS
import com.wachowski.lukasz.countries.utils.Constants.SYNC_INTERVAL_SECONDS
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class DataManager(private val apiHelper: ApiHelper, val modelDao: ModelDao, val context: Context) {

    fun initializeData() {

        val preferences = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)

        if (preferences.getBoolean(PREFS_INITIALIZED, false)) {
            return
        }

        startFetchService()

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
        apiHelper.getData()
            .subscribeOn(Schedulers.io())
            .flatMapCompletable { data ->
                Completable.create {
                    modelDao.insertCountries(data)
                }
            }.subscribe(object : CompletableObserver {
                override fun onSubscribe(@NonNull d: Disposable) {
                    Timber.d("Sync started...")
                }

                override fun onComplete() {
                    Timber.d("Sync finished...")
                }

                override fun onError(@NonNull e: Throwable) {
                    Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
                }
            })
    }
}