package com.stanfit.android.extension.library.context

import android.content.Context
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