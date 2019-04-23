package com.wachowski.lukasz.countries.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.wachowski.lukasz.countries.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val listAdapter = ListAdapter()
    private val viewModel: MainActivityViewModel by viewModel()

//    @Inject
//    lateinit var factory: ViewModelProvider.Factory
//
//    @Inject
//    lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        AndroidInjection.inject(this)

//        viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)

        recyclerView.adapter = listAdapter

        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.countryList.observe(this, Observer { pagedList -> listAdapter.submitList(pagedList) })
    }
}
