package com.wachowski.lukasz.countries.di

import com.wachowski.lukasz.countries.data.remote.ApiHelper
import com.wachowski.lukasz.countries.utils.Constants
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    single {
        createWebService<ApiHelper>()
    }
}

inline fun <reified T> createWebService(): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(Constants.URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(T::class.java)
}