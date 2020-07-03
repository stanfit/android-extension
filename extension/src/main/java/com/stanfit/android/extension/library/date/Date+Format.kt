package com.stanfit.android.extension.library.date

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

private const val TAG = "Date+Format"

/**
 * Format date to string.
 *
 * @param pattern String
 */
fun Date.format(pattern: String): String {
    try {
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        return sdf.format(this)
    } catch (e: Exception) {
        Log.e(TAG, "failure format.", e)
    }
    return ""
}

/**
 * Format string to date.
 *
 * @param pattern String
 * @return Date
 */
fun String.toDate(pattern: String): Date? {
    try {
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        return sdf.parse(this)
    } catch (e: Exception) {
        Log.e(TAG, "failure format.", e)
    }
    return null
}