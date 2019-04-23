package com.wachowski.lukasz.countries

import android.app.Application
import com.wachowski.lukasz.countries.di.modules.repositoryModule
import com.wachowski.lukasz.countries.di.modules.retrofitModule
import com.wachowski.lukasz.countries.di.modules.roomModule
import org.koin.android.ext.android.startKoin

class CountriesApp : Application() {

    /*
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var serviceDispatchingAndroidInjector: DispatchingAndroidInjector<Service>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun serviceInjector(): AndroidInjector<Service> {
        return serviceDispatchingAndroidInjector
    }
    */

    override fun onCreate() {
        super.onCreate()

//        DaggerAppComponent
//            .builder()
//            .application(this)
//            .build()
//            .inject(this)
        initKoin()
    }

    private fun initKoin() {
        startKoin(this, listOf(roomModule, retrofitModule, repositoryModule))
    }
}