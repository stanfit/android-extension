package com.stanfit.android.extension.library.string

/**
 * Format camel case to snake case
 *
 * @return String
 */
fun String.toSnakeCase(): String {
    if (isEmpty()) {
        return this
    }
    val sb = StringBuilder(length + length)
    for (i in 0 until length) {
        val c = this[i]
        if (Character.isUpperCase(c)) {
            sb.append(if (sb.isNotEmpty()) '_' else "").append(Character.toLowerCase(c))
        } else {
            sb.append(Character.toLowerCase(c))
        }
    }
    return sb.toString()
}

/**
 * Format snake case to camel case
 *
 * @return String
 */
fun String.toCamelCase(): String {
    if (isEmpty()) {
        return this
    }
    val sb = StringBuilder(length + length)
    var i = 0
    while (i < length) {
        val c = this[i]
        if (c == '_') {
            sb.append(if (i + 1 < length) Character.toUpperCase(this[++i]) else "")
        } else {
            sb.append(if (sb.isEmpty()) Character.toUpperCase(c) else Character.toLowerCase(c))
        }
        i++
    }
    return sb.toString()
}