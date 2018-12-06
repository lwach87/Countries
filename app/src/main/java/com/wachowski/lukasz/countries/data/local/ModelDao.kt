package com.wachowski.lukasz.countries.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.wachowski.lukasz.countries.data.model.Country
import io.reactivex.Flowable

@Dao
interface ModelDao {

    @get:Query("SELECT * FROM country")
    val getCountries: Flowable<List<Country>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountries(country: List<Country>)
}