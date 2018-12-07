package com.wachowski.lukasz.countries.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.wachowski.lukasz.countries.data.DataManager
import com.wachowski.lukasz.countries.data.model.CountryCurrencies
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MainActivityViewModel(val dataManager: DataManager) : ViewModel() {

    val featureLiveData: MutableLiveData<List<CountryCurrencies>> = MutableLiveData()
    private val disposable: CompositeDisposable? = null

    fun getCountries() {
        disposable?.add(
            dataManager
                .modelDao
                .getCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ country -> featureLiveData.setValue(country) },
                    { error -> Timber.d("Error getting data: %s", error.localizedMessage) })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}
