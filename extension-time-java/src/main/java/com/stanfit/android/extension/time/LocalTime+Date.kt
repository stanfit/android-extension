package com.stanfit.android.extension.java.time

import java.time.LocalTime
import java.util.*

/**
 * Conversion from [Date] to [LocalTime].
 *
 * @return [LocalTime]
 */
fun Date.toLocalTime(): LocalTime {
    val calendar = Calendar.getInstance()
    calendar.time = this
    return LocalTime.of(
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        calendar.get(Calendar.SECOND)
    )
}
