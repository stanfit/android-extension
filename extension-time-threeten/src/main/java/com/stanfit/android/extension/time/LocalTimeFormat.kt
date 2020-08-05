package com.stanfit.android.extension.time

import java.time.LocalTime

/**
 * [LocalTime] Original format definition
 *
 * @property pattern Pattern.
 */
enum class LocalTimeFormat(val pattern: String) {
    HH_MM_SS("HH:mm:ss"),
    HH_MM_SS_SSS("HH:mm:ss.SSS"),
    HH_MM_SS_NO_SPLIT("HHmmss"),
    HH_MM_SS_SSS_NO_SPLIT("HHmmssSSS")
}