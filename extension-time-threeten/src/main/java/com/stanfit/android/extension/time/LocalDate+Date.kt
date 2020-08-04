package com.stanfit.android.extension.time

import org.threeten.bp.LocalDate
import java.util.*

/**
 * Conversion from [Date] to [LocalDate].
 *
 * @return [LocalDate]
 */
fun Date.toLocalDate(): LocalDate {
    val calendar = Calendar.getInstance()
    calendar.time = this
    return LocalDate.of(
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH) + 1,
        calendar.get(Calendar.DAY_OF_MONTH)
    )
}

/**
 * Conversion from [LocalDate] to [Date].
 *
 * @return [Date]
 */
fun LocalDate.toDate(): Date {
    val calendar = Calendar.getInstance()
    calendar.set(year, month.value - 1, dayOfMonth)
    return calendar.time
}