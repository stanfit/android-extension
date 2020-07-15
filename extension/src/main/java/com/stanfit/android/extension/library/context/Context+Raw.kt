package com.stanfit.android.extension.library.context

import android.content.Context
import android.content.res.Resources
import androidx.annotation.RawRes

/**
 * Read text from raw folders.
 *
 * @param resId resource id.
 * @return String
 */
fun Context.readTextFromRaw(@RawRes resId: Int): String {
    return try {
        val inputStream = resources.openRawResource(resId)
        inputStream.bufferedReader().use { it.readText() }
    } catch (e: Resources.NotFoundException) {
        ""
    }
}