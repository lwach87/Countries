package com.wachowski.lukasz.countries.data.model

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName
import com.wachowski.lukasz.countries.utils.Constants.TABLE_COUNTRIES
import com.wachowski.lukasz.countries.utils.Constants.TABLE_CURRENCIES

@Entity(tableName = TABLE_COUNTRIES)
data class Country(
    @PrimaryKey
    @SerializedName("name")
    @ColumnInfo(name = "country")
    val countryName: String,
    @ColumnInfo(name = "topLevelDomain")
    val topLevelDomain: MutableList<String>,
    @ColumnInfo(name = "callingCodes")
    val callingCodes: MutableList<String>
)

class CountryCurrencies {
    @Embedded
    lateinit var country: Country
    @Relation(parentColumn = "country", entityColumn = "owner")
    lateinit var currencyList: List<Currency>
}

@Entity(
    tableName = TABLE_CURRENCIES, foreignKeys =
    [ForeignKey(
        entity = Country::class,
        parentColumns = arrayOf("country"),
        childColumns = arrayOf("owner")
    )]
)
data class Currency(
    @PrimaryKey
    @SerializedName("name")
    @ColumnInfo(name = "currencyName")
    val currencyName: String,
    @ColumnInfo(name = "owner")
    val owner: String,
    @ColumnInfo(name = "code")
    val code: String,
    @ColumnInfo(name = "symbol")
    val symbol: String
)