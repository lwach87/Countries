package com.wachowski.lukasz.countries.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.wachowski.lukasz.countries.data.DataManager
import com.wachowski.lukasz.countries.data.model.Country

class MainActivityViewModel(dataManager: DataManager) : ViewModel() {

    init {
        dataManager.initializeData()
    }

    val countryList: LiveData<PagedList<Country>> =
        LivePagedListBuilder(dataManager.modelDao.getAllCountries(), 15).build()
}
