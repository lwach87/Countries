package com.wachowski.lukasz.countries.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.wachowski.lukasz.countries.utils.Constants.TABLE_COUNTRIES
import com.wachowski.lukasz.countries.utils.Constants.TABLE_CURRENCIES

@Entity(tableName = TABLE_COUNTRIES)
data class Country(
    @PrimaryKey
    @SerializedName("name")
    val countryName: String,
    val topLevelDomain: MutableList<String>,
    val callingCodes: MutableList<String>,
    val currency: List<Currency>
)

@Entity(tableName = TABLE_CURRENCIES)
data class Currency(
    @PrimaryKey
    @SerializedName("name")
    val currencyName: String,
    val code: String,
    val symbol: String
)