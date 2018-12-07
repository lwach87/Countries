package com.wachowski.lukasz.countries.data.local

import android.arch.persistence.room.*
import com.wachowski.lukasz.countries.data.model.Country
import com.wachowski.lukasz.countries.data.model.CountryCurrencies
import com.wachowski.lukasz.countries.data.model.Currency
import io.reactivex.Flowable

@Dao
abstract class ModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCountries(country: List<Country>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCurrencies(currency: List<Currency>)

    @Transaction
    @Query("SELECT * FROM countries")
    abstract fun getCountries(): Flowable<List<CountryCurrencies>>

//    @Transaction
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(country: Country, currency: List<Currency>) {
//            insertCountries(country)
//            insertCurrencies(currency)
//        }
}