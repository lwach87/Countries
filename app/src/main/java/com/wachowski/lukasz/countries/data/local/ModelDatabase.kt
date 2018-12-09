package com.wachowski.lukasz.countries.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.wachowski.lukasz.countries.data.model.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ModelDatabase : RoomDatabase() {

    abstract fun modelDao(): ModelDao
}