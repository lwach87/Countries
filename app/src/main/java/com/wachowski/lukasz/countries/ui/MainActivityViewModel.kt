package com.wachowski.lukasz.countries.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.wachowski.lukasz.countries.data.DataManager
import com.wachowski.lukasz.countries.data.model.Country

class MainActivityViewModel(dataManager: DataManager) : ViewModel() {

    init {
        dataManager.initializeData()
    }

    val countryList: LiveData<PagedList<Country>> =
        LivePagedListBuilder(dataManager.modelDao.getAllCountries(), 15).build()
}
