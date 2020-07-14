package com.stanfit.android.extension.library.date

import android.text.format.DateUtils
import java.util.*

/**
 * Check today.
 *
 * @return Boolean
 */
fun Date.isToday(): Boolean {
    return DateUtils.isToday(time)
}

/**
 * Check yesterday.
 *
 * @return Boolean
 */
fun Date.isYesterday(): Boolean {
    return DateUtils.isToday(time + DateUtils.DAY_IN_MILLIS)
}

/**
 * Check tomorrow.
 *
 * @return Boolean
 */
fun Date.isTomorrow(): Boolean {
    return DateUtils.isToday(time - DateUtils.DAY_IN_MILLIS)
}

/**
 * Check this month.
 *
 * @return Boolean
 */
fun Date.isThisMonth(): Boolean {
    val target = Calendar.getInstance()
    target.time = this
    val current = Calendar.getInstance()
    return target.get(Calendar.MONTH) == current.get(Calendar.MONTH)
}

/**
 * Check this year.
 *
 * @return Boolean
 */
fun Date.isThisYear(): Boolean {
    val target = Calendar.getInstance()
    target.time = this
    val current = Calendar.getInstance()
    return target.get(Calendar.YEAR) == current.get(Calendar.YEAR)
}