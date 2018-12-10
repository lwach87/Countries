package com.wachowski.lukasz.countries.data.local

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.wachowski.lukasz.countries.data.model.Country

@Dao
interface ModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountries(country: List<Country>)

    @Query("SELECT * FROM countries")
    fun getAllCountries(): DataSource.Factory<Int, Country>
}