package com.wachowski.lukasz.countries.data.remote

import com.wachowski.lukasz.countries.data.model.Country
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiHelper {

    @GET("/rest/v2/all")
    fun getData(): Flowable<List<Country>>
}