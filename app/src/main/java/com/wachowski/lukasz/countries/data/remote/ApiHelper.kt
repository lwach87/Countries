package com.wachowski.lukasz.countries.data.remote

import com.wachowski.lukasz.countries.data.model.Country
import com.wachowski.lukasz.countries.data.model.Currency
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiHelper {

    @get:GET("/rest/v2/all")
    val data: Flowable<List<Country>>

    @GET("/rest/v2/all/{name}")
    fun currencyData(@Path(value = "name") name: String): Flowable<List<Currency>>
}