package com.wachowski.lukasz.countries.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wachowski.lukasz.countries.data.model.Currency

object Converters {

    @TypeConverter
    @JvmStatic
    fun fromCurrencyList(currencies: List<Currency>?): String? {
        return Gson().toJson(currencies)
    }

    @TypeConverter
    @JvmStatic
    fun toCurrencyList(currencyString: String?): List<Currency>? {
        val type = object : TypeToken<List<Currency>>() {}.type
        return Gson().fromJson(currencyString, type)
    }

    @TypeConverter
    @JvmStatic
    fun domainToString(domain: List<String>?): String? =
        domain?.joinToString(separator = ",") { it }

    @TypeConverter
    @JvmStatic
    fun domainToList(domain: String?): List<String>? =
        domain?.split(",")?.asSequence()?.map { it }?.toList()
}
