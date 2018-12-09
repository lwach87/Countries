package com.wachowski.lukasz.countries.data.local

import com.wachowski.lukasz.countries.data.model.Country
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDbHelper @Inject constructor(private var modelDatabase: ModelDatabase) : DbHelper {

    override fun getCountries(): Flowable<List<Country>> {
        return Flowable.fromCallable { modelDatabase.modelDao().getCountries() }
    }

    override fun insertCountries(counties: List<Country>) {
        modelDatabase.modelDao().insertCountries(counties)
    }
}