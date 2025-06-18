package com.adammcneilly.spacenerd.shared.data.local.room.typeconverters

import androidx.room.TypeConverter
import kotlin.jvm.JvmStatic

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
