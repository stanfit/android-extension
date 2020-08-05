package com.stanfit.android.extension.java.time

import java.time.DateTimeException
import java.time.LocalTime
import java.time.format.DateTimeFormatter

/**
 * Conversion from [String] to [LocalTime].
 *
 * @param format [LocalTimeFormat]
 * @throws DateTimeException If string can't convert.
 * @return [LocalTime]
 */
@Throws(DateTimeException::class)
fun String.toLocalTime(format: String): LocalTime {
    val formatter = DateTimeFormatter.ofPattern(format)
    return LocalTime.parse(this, formatter)
}

/**
 * Conversion from [String] to [LocalTime].
 *
 * @param format [LocalTimeFormat]
 * @throws DateTimeException If string can't convert.
 * @return [LocalTime]
 */
fun String.toLocalTimeOrNull(format: String): LocalTime? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format)
        LocalTime.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * Conversion from [String] to [LocalTime].
 *
 * @param format [LocalTimeFormat]
 * @throws DateTimeException If string can't convert.
 * @return [LocalTime]
 */
@Throws(DateTimeException::class)
fun String.toLocalTime(format: LocalTimeFormat): LocalTime {
    val formatter = DateTimeFormatter.ofPattern(format.pattern)
    return LocalTime.parse(this, formatter)
}

/**
 * Conversion from [String] to [LocalTime].
 *
 * @param format [LocalTimeFormat]
 * @return [LocalTime]
 */
fun String.toLocalTimeOrNull(format: LocalTimeFormat): LocalTime? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format.pattern)
        return LocalTime.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * Conversion from [LocalTime] to [String].
 *
 * @param format [LocalTimeFormat]
 * @return [String]
 */
fun LocalTime.toString(format: String): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format)
        format(formatter)
    } catch (e: Exception) {
        ""
    }
}

/**
 * Conversion from [LocalTime] to [String].
 *
 * @param format [LocalTimeFormat]
 * @return [String]
 */
fun LocalTime.toString(format: LocalTimeFormat): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format.pattern)
        format(formatter)
    } catch (e: Exception) {
        ""
    }
}
