package com.wachowski.lukasz.countries.di.builder

import com.wachowski.lukasz.countries.ui.MainActivity
import com.wachowski.lukasz.countries.ui.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}