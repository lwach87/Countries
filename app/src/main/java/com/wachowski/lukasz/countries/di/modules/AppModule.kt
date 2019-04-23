package com.wachowski.lukasz.countries.di.modules

/*
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
*/