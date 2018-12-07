package com.wachowski.lukasz.countries.data.local

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wachowski.lukasz.countries.data.model.Currency

object Converters {

    @TypeConverter
    @JvmStatic
    fun domainToString(domain: MutableList<String>?): String? =
        domain?.joinToString(separator = ",") { it }

    @TypeConverter
    @JvmStatic
    fun domainToList(domain: String?): MutableList<String>? =
        domain?.split(",")?.asSequence()?.map { it }?.toMutableList()

    @TypeConverter
    @JvmStatic
    fun fromCurrencyList(currency: List<Currency>?): String? {
        val type = object : TypeToken<List<Currency>>() {}.type
        return Gson().toJson(currency, type)
    }

    @TypeConverter
    @JvmStatic
    fun toCurrencyList(currencyString: String?): List<Currency>? {
        val type = object : TypeToken<List<Currency>>() {}.type
        return Gson().fromJson(currencyString, type)
    }
}
