package com.wachowski.lukasz.countries.di

import com.wachowski.lukasz.countries.data.DataManager
import com.wachowski.lukasz.countries.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val repositoryModule = module {

    single { DataManager(get(), get(), get()) }

    viewModel { MainActivityViewModel(get()) }
}