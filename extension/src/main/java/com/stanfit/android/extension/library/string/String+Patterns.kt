package com.stanfit.android.extension.library.string

import android.util.Patterns
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Check web email.
 *
 * @return Boolean
 */
@OptIn(ExperimentalContracts::class)
fun String?.isEmail(): Boolean {
    contract {
        returns(true) implies (this@isEmail != null)
    }
    return this != null && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

/**
 * Check web phone number.
 *
 * @return Boolean
 */
@OptIn(ExperimentalContracts::class)
fun String?.isPhone(): Boolean {
    contract {
        returns(true) implies (this@isPhone != null)
    }
    return this != null && Patterns.PHONE.matcher(this).matches()
}

/**
 * Check web url.
 *
 * @return Boolean
 */
@OptIn(ExperimentalContracts::class)
fun String?.isWebUrl(): Boolean {
    contract {
        returns(true) implies (this@isWebUrl != null)
    }
    return this != null && Patterns.WEB_URL.matcher(this).matches()
}