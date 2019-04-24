package com.wachowski.lukasz.countries.data

import android.app.IntentService
import android.content.Intent
import com.wachowski.lukasz.countries.utils.Constants.SYNC_SERVICE
import org.koin.android.ext.android.inject


class DataSyncIntentService : IntentService(SYNC_SERVICE) {

    private val dataManager: DataManager by inject()

    override fun onHandleIntent(intent: Intent?) {
        dataManager.syncData()
    }
}