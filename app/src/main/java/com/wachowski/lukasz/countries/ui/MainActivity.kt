package com.wachowski.lukasz.countries.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wachowski.lukasz.countries.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var listAdapter: ListAdapter

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)

        recycler_view.adapter = listAdapter

        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.countryList.observe(this, Observer { pagedList -> listAdapter.submitList(pagedList) })
    }
}
