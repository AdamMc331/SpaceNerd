package com.adammcneilly.spacenerd.data.article.impl.local.room

import androidx.room.TypeConverter
import kotlin.jvm.JvmStatic

/**
 * TODO: Put this in a common module.
 */
@Suppress("ForbiddenComment")
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
