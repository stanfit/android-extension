package com.stanfit.android.extension.time

import org.threeten.bp.LocalDateTime
import java.util.*

/**
 * Conversion from [Date] to [LocalDateTime].
 *
 * @return [LocalDateTime]
 */
fun Date.toLocalDateTime(): LocalDateTime {
    val calendar = Calendar.getInstance()
    calendar.time = this
    return LocalDateTime.of(
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH) + 1,
        calendar.get(Calendar.DAY_OF_MONTH),
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE)
    )
}

/**
 * Conversion from [LocalDateTime] to [Date].
 *
 * @return [Date]
 */
fun LocalDateTime.toDate(): Date {
    val calendar = Calendar.getInstance()
    calendar.set(year, month.value - 1, dayOfMonth, hour, minute, second)
    return calendar.time
}