package com.wachowski.lukasz.countries.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.wachowski.lukasz.countries.data.DataManager
import com.wachowski.lukasz.countries.data.local.ModelDao
import com.wachowski.lukasz.countries.data.local.ModelDatabase
import com.wachowski.lukasz.countries.data.remote.ApiHelper
import com.wachowski.lukasz.countries.utils.Constants
import com.wachowski.lukasz.countries.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun context(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun modelDatabase(context: Context): ModelDatabase {
        return Room.databaseBuilder(context, ModelDatabase::class.java, DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiHelper(retrofit: Retrofit): ApiHelper {
        return retrofit.create<ApiHelper>(ApiHelper::class.java)
    }

    @Provides
    @Singleton
    fun provideModelDao(modelDatabase: ModelDatabase): ModelDao {
        return modelDatabase.modelDao()
    }

    @Provides
    @Singleton
    fun provideDataManager(apiHelper: ApiHelper, modelDao: ModelDao, context: Context): DataManager {
        return DataManager(apiHelper, modelDao, context)
    }
}