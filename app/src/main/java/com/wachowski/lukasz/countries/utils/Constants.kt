package com.wachowski.lukasz.countries.utils

import com.wachowski.lukasz.countries.data.DataManager

object Constants {

    const val URL = "https://restcountries.eu"
    const val SYNC_SERVICE = "DataSyncIntentService"
    const val DATABASE_NAME = "Project"
    const val TABLE_COUNTRIES = "countries"
    const val TABLE_CURRENCIES = "currencies"
    const val PREFS_NAME = "view.prefs"
    const val PREFS_INITIALIZED = "initialized"

    val DATA_TAG: String = DataManager::class.java.simpleName
    //    private const val SYNC_INTERVAL_HOURS = 16
//    val SYNC_INTERVAL_SECONDS = TimeUnit.HOURS.toSeconds(SYNC_INTERVAL_HOURS.toLong()).toInt()
    val SYNC_INTERVAL_SECONDS = 30
    const val SYNC_FLEXTIME_SECONDS = 60
}