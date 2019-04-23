package com.wachowski.lukasz.countries.data.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wachowski.lukasz.countries.data.model.Country

@Dao
interface ModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountries(country: List<Country>)

    @Query("SELECT * FROM countries")
    fun getAllCountries(): DataSource.Factory<Int, Country>
}