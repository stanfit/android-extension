package com.stanfit.android.extension.java.time

import java.time.DateTimeException
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * Conversion from [String] to [ZonedDateTime].
 *
 * @param format [ZonedDateTimeFormat]
 * @throws DateTimeException If string can't convert.
 * @return [ZonedDateTime]
 */
@Throws(DateTimeException::class)
fun String.toZonedDateTime(format: String): ZonedDateTime {
    val formatter = DateTimeFormatter.ofPattern(format)
    return ZonedDateTime.parse(this, formatter)
}

/**
 * Conversion from [String] to [ZonedDateTime].
 *
 * @param format [ZonedDateTimeFormat]
 * @throws DateTimeException If string can't convert.
 * @return [ZonedDateTime]
 */
fun String.toZonedDateTimeOrNull(format: String): ZonedDateTime? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format)
        ZonedDateTime.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * Conversion from [String] to [ZonedDateTime].
 *
 * @param format [ZonedDateTimeFormat]
 * @throws DateTimeException If string can't convert.
 * @return [ZonedDateTime]
 */
@Throws(DateTimeException::class)
fun String.toZonedDateTime(format: ZonedDateTimeFormat): ZonedDateTime {
    val formatter = DateTimeFormatter.ofPattern(format.pattern)
    return ZonedDateTime.parse(this, formatter)
}

/**
 * Conversion from [String] to [ZonedDateTime].
 *
 * @param format [ZonedDateTimeFormat]
 * @return [ZonedDateTime]
 */
fun String.toZonedDateTimeOrNull(format: ZonedDateTimeFormat): ZonedDateTime? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format.pattern)
        return ZonedDateTime.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * Conversion from [ZonedDateTime] to [String].
 *
 * @param format [ZonedDateTimeFormat]
 * @return [String]
 */
fun ZonedDateTime.toString(format: String): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format)
        format(formatter)
    } catch (e: Exception) {
        ""
    }
}

/**
 * Conversion from [ZonedDateTime] to [String].
 *
 * @param format [ZonedDateTimeFormat]
 * @return [String]
 */
fun ZonedDateTime.toString(format: ZonedDateTimeFormat): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format.pattern)
        format(formatter)
    } catch (e: Exception) {
        ""
    }
}