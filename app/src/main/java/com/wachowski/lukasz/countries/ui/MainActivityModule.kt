package com.wachowski.lukasz.countries.ui

import android.arch.lifecycle.ViewModelProvider
import com.wachowski.lukasz.countries.ViewModelProviderFactory
import com.wachowski.lukasz.countries.data.DataManager
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideAdapter(): ListAdapter {
        return ListAdapter()
    }

    @Provides
    fun provideMainViewModel(dataManager: DataManager): MainActivityViewModel {
        return MainActivityViewModel(dataManager)
    }

    @Provides
    fun mainViewModelProvider(mainViewModel: MainActivityViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }
}