package com.stanfit.android.extension.java.time

import java.time.DateTimeException
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

/**
 * Conversion from [String] to [OffsetDateTime].
 *
 * @param format [OffsetDateTimeFormat]
 * @throws DateTimeException If string can't convert.
 * @return [OffsetDateTime]
 */
@Throws(DateTimeException::class)
fun String.toOffsetDateTime(format: String): OffsetDateTime {
    val formatter = DateTimeFormatter.ofPattern(format)
    return OffsetDateTime.parse(this, formatter)
}

/**
 * Conversion from [String] to [OffsetDateTime].
 *
 * @param format [OffsetDateTimeFormat]
 * @throws DateTimeException If string can't convert.
 * @return [OffsetDateTime]
 */
fun String.toOffsetDateTimeOrNull(format: String): OffsetDateTime? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format)
        OffsetDateTime.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * Conversion from [String] to [OffsetDateTime].
 *
 * @param format [OffsetDateTimeFormat]
 * @throws DateTimeException If string can't convert.
 * @return [OffsetDateTime]
 */
@Throws(DateTimeException::class)
fun String.toOffsetDateTime(format: OffsetDateTimeFormat): OffsetDateTime {
    val formatter = DateTimeFormatter.ofPattern(format.pattern)
    return OffsetDateTime.parse(this, formatter)
}

/**
 * Conversion from [String] to [OffsetDateTime].
 *
 * @param format [OffsetDateTimeFormat]
 * @return [OffsetDateTime]
 */
fun String.toOffsetDateTimeOrNull(format: OffsetDateTimeFormat): OffsetDateTime? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format.pattern)
        return OffsetDateTime.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * Conversion from [OffsetDateTime] to [String].
 *
 * @param format [OffsetDateTimeFormat]
 * @return [String]
 */
fun OffsetDateTime.toString(format: String): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format)
        format(formatter)
    } catch (e: Exception) {
        ""
    }
}

/**
 * Conversion from [OffsetDateTime] to [String].
 *
 * @param format [OffsetDateTimeFormat]
 * @return [String]
 */
fun OffsetDateTime.toString(format: OffsetDateTimeFormat): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format.pattern)
        format(formatter)
    } catch (e: Exception) {
        ""
    }
}
