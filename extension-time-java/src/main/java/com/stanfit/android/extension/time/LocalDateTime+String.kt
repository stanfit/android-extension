package com.stanfit.android.extension.java.time

import java.time.DateTimeException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Conversion from [String] to [LocalDateTime].
 *
 * @param format [LocalDateTimeFormat]
 * @throws DateTimeException If string can't convert.
 * @return [LocalDateTime]
 */
@Throws(DateTimeException::class)
fun String.toLocalDateTime(format: String): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern(format)
    return LocalDateTime.parse(this, formatter)
}

/**
 * Conversion from [String] to [LocalDateTime].
 *
 * @param format [LocalDateTimeFormat]
 * @throws DateTimeException If string can't convert.
 * @return [LocalDateTime]
 */
fun String.toLocalDateTimeOrNull(format: String): LocalDateTime? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format)
        LocalDateTime.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * Conversion from [String] to [LocalDateTime].
 *
 * @param format [LocalDateTimeFormat]
 * @throws DateTimeException If string can't convert.
 * @return [LocalDateTime]
 */
@Throws(DateTimeException::class)
fun String.toLocalDateTime(format: LocalDateTimeFormat): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern(format.pattern)
    return LocalDateTime.parse(this, formatter)
}

/**
 * Conversion from [String] to [LocalDateTime].
 *
 * @param format [LocalDateTimeFormat]
 * @return [LocalDateTime]
 */
fun String.toLocalDateTimeOrNull(format: LocalDateTimeFormat): LocalDateTime? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format.pattern)
        return LocalDateTime.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * Conversion from [LocalDateTime] to [String].
 *
 * @param format [LocalDateTimeFormat]
 * @return [String]
 */
fun LocalDateTime.toString(format: String): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format)
        format(formatter)
    } catch (e: Exception) {
        ""
    }
}

/**
 * Conversion from [LocalDateTime] to [String].
 *
 * @param format [LocalDateTimeFormat]
 * @return [String]
 */
fun LocalDateTime.toString(format: LocalDateTimeFormat): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format.pattern)
        format(formatter)
    } catch (e: Exception) {
        ""
    }
}
