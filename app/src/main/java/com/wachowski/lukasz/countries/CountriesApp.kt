package com.wachowski.lukasz.countries

import android.app.Application
import com.wachowski.lukasz.countries.di.repositoryModule
import com.wachowski.lukasz.countries.di.retrofitModule
import com.wachowski.lukasz.countries.di.roomModule
import org.koin.android.ext.android.startKoin

class CountriesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin(this, listOf(roomModule, retrofitModule, repositoryModule))
    }
}