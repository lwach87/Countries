package com.wachowski.lukasz.countries.di.component

import android.app.Application
import com.wachowski.lukasz.countries.CountriesApp
import com.wachowski.lukasz.countries.di.modules.AppModule
import com.wachowski.lukasz.countries.di.builder.DataServiceBuilder
import com.wachowski.lukasz.countries.di.builder.ActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class,
        DataServiceBuilder::class]
)
interface AppComponent {

    fun inject(app: CountriesApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}