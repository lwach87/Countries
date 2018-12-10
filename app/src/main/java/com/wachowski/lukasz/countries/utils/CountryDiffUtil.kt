package com.wachowski.lukasz.countries.utils

import android.support.v7.util.DiffUtil
import com.wachowski.lukasz.countries.data.model.Country

class CountryDiffUtil : DiffUtil.ItemCallback<Country>() {

    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.countryName == newItem.countryName
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem == newItem
    }
}