package com.wachowski.lukasz.countries.data.local

import android.arch.persistence.room.TypeConverter

object Converters {

    @TypeConverter
    @JvmStatic
    fun domainToString(domain: MutableList<String>?): String? =
        domain?.joinToString(separator = ",") { it }

    @TypeConverter
    @JvmStatic
    fun domainToList(domain: String?): MutableList<String>? =
        domain?.split(",")?.asSequence()?.map { it }?.toMutableList()
}
