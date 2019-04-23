package com.wachowski.lukasz.countries.ui

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wachowski.lukasz.countries.R
import com.wachowski.lukasz.countries.data.model.Country
import com.wachowski.lukasz.countries.utils.CountryDiffUtil
import kotlinx.android.synthetic.main.single_data.view.*

class ListAdapter : PagedListAdapter<Country, ListAdapter.DataViewHolder>(CountryDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_data, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        val country = getItem(position)

        if (country != null) {
            holder.bind(country)
        } else {
            holder.clear()
        }
    }

    class DataViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

        private val tvCountry = view.tv_country
        private val tvDomain = view.tv_domain
        private val tvPhone = view.tv_phone
        private val tvCurrency = view.tv_currency

        fun bind(country: Country) {
            tvCountry.text = country.countryName
            tvDomain.text = country.topLevelDomain.joinToString(separator = ", ")
            tvPhone.text = country.callingCodes.joinToString(separator = ", ")
            tvCurrency.text = country.currencies.joinToString(separator = ", ") { it.currencyName }
        }

        fun clear() {
            tvCountry.text = null
            tvDomain.text = null
            tvPhone.text = null
            tvCurrency.text = null
        }
    }
}