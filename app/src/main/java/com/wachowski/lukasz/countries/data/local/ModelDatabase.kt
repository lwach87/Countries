package com.wachowski.lukasz.countries.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wachowski.lukasz.countries.data.model.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ModelDatabase : RoomDatabase() {

    abstract fun modelDao(): ModelDao
}