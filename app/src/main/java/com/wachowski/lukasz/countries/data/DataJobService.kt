package com.wachowski.lukasz.countries.data

import com.firebase.jobdispatcher.JobParameters
import com.firebase.jobdispatcher.JobService
import org.koin.android.ext.android.inject


class DataJobService : JobService() {

    private val dataManager: DataManager by inject()

    override fun onStartJob(job: JobParameters): Boolean {
        dataManager.syncData()
        jobFinished(job, false)
        return true
    }

    override fun onStopJob(job: JobParameters): Boolean {
        return true
    }
}