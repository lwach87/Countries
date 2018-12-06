package com.wachowski.lukasz.countries.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.wachowski.lukasz.countries.data.model.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
abstract class ModelDatabase : RoomDatabase() {

    abstract fun modelDao(): ModelDao
}