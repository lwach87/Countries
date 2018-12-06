package com.wachowski.lukasz.countries.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wachowski.lukasz.countries.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
        viewModel.getCountries()
        subscribeToLiveData()

        if (savedInstanceState == null) {
            viewModel.dataManager.initializeData()
        }
    }

    private fun subscribeToLiveData() {
//        viewModel.featureLiveData.observe(this, Observer { country ->  })
    }
}
