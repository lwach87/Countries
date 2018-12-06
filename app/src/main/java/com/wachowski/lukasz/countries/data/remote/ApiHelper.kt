package com.wachowski.lukasz.countries.data.remote

import com.wachowski.lukasz.countries.data.model.Country
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiHelper {

    @get:GET("/rest/v2/all")
    val data: Flowable<List<Country>>
}