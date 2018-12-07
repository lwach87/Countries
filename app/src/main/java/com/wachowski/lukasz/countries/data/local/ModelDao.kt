package com.wachowski.lukasz.countries.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.wachowski.lukasz.countries.data.model.Country
import io.reactivex.Flowable

@Dao
abstract class ModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCountries(country: List<Country>)

    @Query("SELECT * FROM countries")
    abstract fun getCountries(): Flowable<List<Country>>
}