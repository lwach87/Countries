package com.wachowski.lukasz.countries.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.wachowski.lukasz.countries.utils.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Country(
    @PrimaryKey
    @SerializedName("name")
    val countryName: String
//    val topLevelDomain: List<String>,
//    val callingCodes: List<String>,
//    val currencies: List<Currency>,
)

data class Currency(
    val code: String,
    @SerializedName("name")
    val currencyName: String,
    val symbol: String
)