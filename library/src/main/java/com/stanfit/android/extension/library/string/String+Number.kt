package com.stanfit.android.extension.library.string

/**
 * Take only number.
 * $1,000 -> 1000
 *
 * @return String
 */
fun String.removeNonNumber(): String {
    val pattern = Regex("[^0-9]")
    return pattern.replace(this, "")
}