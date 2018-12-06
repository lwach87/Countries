package com.wachowski.lukasz.countries.data

import android.util.Log
import com.firebase.jobdispatcher.JobParameters
import com.firebase.jobdispatcher.JobService
import dagger.android.AndroidInjection
import javax.inject.Inject


class DataJobService : JobService() {

    @Inject
    lateinit var dataManager: DataManager

    override fun onStartJob(job: JobParameters): Boolean {
        Log.d("Debugger", "FIREBASE STARTED")
        dataManager.syncData()
        jobFinished(job, false)
        return true
    }

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }

    override fun onStopJob(job: JobParameters): Boolean {
        return true
    }
}