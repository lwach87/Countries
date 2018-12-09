package com.wachowski.lukasz.countries.data

import android.app.IntentService
import android.content.Intent
import com.wachowski.lukasz.countries.utils.Constants.SYNC_SERVICE
import dagger.android.AndroidInjection
import javax.inject.Inject


class DataSyncIntentService : IntentService(SYNC_SERVICE) {

    @Inject
    lateinit var dataManager: DataManager

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }

    override fun onHandleIntent(intent: Intent?) {
        dataManager.syncData()
    }
}