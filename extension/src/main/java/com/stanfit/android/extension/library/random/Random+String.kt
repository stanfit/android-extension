package com.stanfit.android.extension.library.random

import kotlin.random.Random

/**
 * large characters.
 */
private const val UPPER_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

/**
 * small characters.
 */
private const val LOWER_ALPHABET = "abcdefghijklmnopqrstuvwxyz"

/**
 * number characters.
 */
private const val NUMBER = "0123456789"

/**
 * Create random characters.
 *
 * @param length length
 * @param symbols including characters
 * @return random characters.
 */
fun Random.nextString(
    length: Int,
    vararg symbols: String = arrayOf(UPPER_ALPHABET, LOWER_ALPHABET, NUMBER)
): String {
    var randomString = ""
    val symbolString = symbols.joinToString(separator = "")
    for (i in 0 until length) {
        randomString += symbolString[nextInt(symbolString.count())]
    }
    return randomString
}