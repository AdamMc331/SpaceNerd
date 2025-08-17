package com.adammcneilly.spacenerd.data.local.room.converters

import androidx.room.TypeConverter
import kotlin.jvm.JvmStatic

/**
 * This is an implementation of a Room database [TypeConverter] that will map a list of strings
 * into a single string for storage, and parsed back into a list on read.
 *
 * This is a simpler, albeit non-normalized, approach of a joining table.
 */
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
