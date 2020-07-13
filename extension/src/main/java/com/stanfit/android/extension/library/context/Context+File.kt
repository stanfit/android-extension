package com.stanfit.android.extension.library.context

import android.content.Context
import android.content.res.Resources
import androidx.annotation.RawRes
import java.io.IOException

/**
 * Read text from assets folders.
 *
 * @param fileName file name.
 * @return String
 */
fun Context.readTextFromAssets(fileName: String): String {
    return try {
        val inputStream = assets.open(fileName)
        inputStream.bufferedReader().use { it.readText() }
    } catch (e: IOException) {
        ""
    }
}

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