package com.wachowski.lukasz.countries.utils

import android.support.v7.util.DiffUtil
import com.wachowski.lukasz.countries.data.model.Country

class FeatureDiffUtil(private val oldList: List<Country>, private val newList: List<Country>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].countryName == newList[newItemPosition].countryName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].capital == newList[newItemPosition].capital
    }
}