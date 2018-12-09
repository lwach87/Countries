package com.wachowski.lukasz.countries.data.local

import com.wachowski.lukasz.countries.data.model.Country
import io.reactivex.Flowable

interface DbHelper {

    fun getCountries(): Flowable<List<Country>>

    fun insertCountries(counties: List<Country>)
}