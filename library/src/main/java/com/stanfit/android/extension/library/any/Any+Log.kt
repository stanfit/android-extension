package com.stanfit.android.extension.library.any

/**
 * Get class name for log.
 *
 * @return String
 */
val Any.simpleName: String get() = javaClass.simpleName

/**
 * Get class name for log.
 *
 * @param any Any
 * @return String
 */
fun Any.simpleName(any: Any?): String {
    if (any == null) return ""
    return any.simpleName
}