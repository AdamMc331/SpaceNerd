package com.adammcneilly.spacenerd.data.room.typeconverters

import androidx.room.TypeConverter

object StringListTypeConverter {
    @TypeConverter
    @JvmStatic
    fun fromStringList(
        value: List<String>?,
    ): String? {
        return value?.joinToString(separator = ",")
    }

    @TypeConverter
    @JvmStatic
    fun toStringList(
        value: String?,
    ): List<String>? {
        return value?.split(',')?.map { it.trim() }?.filterNot { it.isEmpty() }
    }
}
