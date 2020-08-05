package com.stanfit.android.extension.java.time

import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Conversion from [String] to [LocalDate].
 *
 * @param format [LocalDateFormat]
 * @throws DateTimeException If string can't convert.
 * @return [LocalDate]
 */
@Throws(DateTimeException::class)
fun String.toLocalDate(format: String): LocalDate {
    val formatter = DateTimeFormatter.ofPattern(format)
    return LocalDate.parse(this, formatter)
}

/**
 * Conversion from [String] to [LocalDate].
 *
 * @param format [LocalDateFormat]
 * @throws DateTimeException If string can't convert.
 * @return [LocalDate]
 */
fun String.toLocalDateOrNull(format: String): LocalDate? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format)
        LocalDate.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * Conversion from [String] to [LocalDate].
 *
 * @param format [LocalDateFormat]
 * @throws DateTimeException If string can't convert.
 * @return [LocalDate]
 */
@Throws(DateTimeException::class)
fun String.toLocalDate(format: LocalDateFormat): LocalDate {
    val formatter = DateTimeFormatter.ofPattern(format.pattern)
    return LocalDate.parse(this, formatter)
}

/**
 * Conversion from [String] to [LocalDate].
 *
 * @param format [LocalDateFormat]
 * @return [LocalDate]
 */
fun String.toLocalDateOrNull(format: LocalDateFormat): LocalDate? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format.pattern)
        return LocalDate.parse(this, formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * Conversion from [LocalDate] to [String].
 *
 * @param format [LocalDateFormat]
 * @return [String]
 */
fun LocalDate.toString(format: String): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format)
        format(formatter)
    } catch (e: Exception) {
        ""
    }
}

/**
 * Conversion from [LocalDate] to [String].
 *
 * @param format [LocalDateFormat]
 * @return [String]
 */
fun LocalDate.toString(format: LocalDateFormat): String {
    return try {
        val formatter = DateTimeFormatter.ofPattern(format.pattern)
        format(formatter)
    } catch (e: Exception) {
        ""
    }
}
