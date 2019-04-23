package com.wachowski.lukasz.countries.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.wachowski.lukasz.countries.utils.Constants.TABLE_COUNTRIES

@Entity(tableName = TABLE_COUNTRIES)
data class Country(
    @PrimaryKey
    @SerializedName("name")
    val countryName: String,
    val topLevelDomain: List<String>,
    val callingCodes: List<String>,
    val currencies: List<Currency>
)

data class Currency(
    @SerializedName("name")
    val currencyName: String,
    val code: String,
    val symbol: String
)