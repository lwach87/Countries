package com.wachowski.lukasz.countries.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wachowski.lukasz.countries.R
import com.wachowski.lukasz.countries.data.model.CountryCurrencies
import kotlinx.android.synthetic.main.single_data.view.*
import java.util.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.DataViewHolder>() {

    private val data = ArrayList<CountryCurrencies>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.DataViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_data, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.country.text = data[position].country.countryName
        holder.domain.text = data[position].country.topLevelDomain.joinToString("'")
        holder.phone.text = data[position].country.callingCodes.joinToString("'")
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val country = view.tv_country!!
        val domain = view.tv_domain!!
        val phone = view.tv_phone!!
//        val currency = view.tv_currency!!
    }

    fun swapData(newList: List<CountryCurrencies>) {
        data.addAll(newList)
        notifyDataSetChanged()
    }
}