package com.stanfit.android.extension.library.string


import android.util.Patterns

/**
 * Check web email.
 *
 * @return Boolean
 */
fun String.isEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

/**
 * Check web phone number.
 *
 * @return Boolean
 */
fun String.isPhone(): Boolean {
    return Patterns.PHONE.matcher(this).matches()
}

/**
 * Check web url.
 *
 * @return Boolean
 */
fun String.isWebUrl(): Boolean {
    return Patterns.WEB_URL.matcher(this).matches()
}