package com.stanfit.android.extension.library.date

import java.util.*

/**
 * Convert date to calendar.
 *
 * @param zone TimeZone
 * @param locale Locale
 * @return Calendar
 */
fun Date.toCalendar(
    zone: TimeZone = TimeZone.getDefault(),
    locale: Locale = Locale.getDefault()
): Calendar {
    val calendar = Calendar.getInstance(zone, locale)
    calendar.time = this
    return calendar
}