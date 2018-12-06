package com.wachowski.lukasz.countries.di.builder

import com.wachowski.lukasz.countries.data.DataJobService
import com.wachowski.lukasz.countries.data.DataSyncIntentService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DataServiceBuilder {

    @ContributesAndroidInjector
    abstract fun provideIntentService(): DataSyncIntentService

    @ContributesAndroidInjector
    abstract fun provideDataJobService(): DataJobService
}