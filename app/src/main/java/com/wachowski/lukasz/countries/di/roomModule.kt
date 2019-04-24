package com.wachowski.lukasz.countries.di

import androidx.room.Room
import com.wachowski.lukasz.countries.data.local.ModelDatabase
import com.wachowski.lukasz.countries.utils.Constants.DATABASE_NAME
import org.koin.dsl.module.module

val roomModule = module {

    single {
        Room.databaseBuilder(get(), ModelDatabase::class.java, DATABASE_NAME)
            .build()
    }

    single { get<ModelDatabase>().modelDao() }
}