package com.stanfit.android.extension.library.number

import java.text.NumberFormat
import java.util.*

/**
 * Format to currency string.
 *
 * @param locale Locale
 * @return Currency format.
 */
fun Int.toCurrency(locale: Locale = Locale.getDefault()): String {
    return NumberFormat.getCurrencyInstance(locale).format(this)
}

/**
 * Format to currency string.
 *
 * @param locale Locale
 * @return Currency format.
 */
fun Long.toCurrency(locale: Locale = Locale.getDefault()): String {
    return NumberFormat.getCurrencyInstance(locale).format(this)
}

/**
 * Format to currency string.
 *
 * @param locale Locale
 * @return Currency format.
 */
fun Double.toCurrency(locale: Locale = Locale.getDefault()): String {
    return NumberFormat.getCurrencyInstance(locale).format(this)
}