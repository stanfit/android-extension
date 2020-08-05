package com.stanfit.android.extension.java.time

import java.time.LocalDate

/**
 * [LocalDate] Original format definition
 *
 * @property pattern Pattern
 */
enum class LocalDateFormat(val pattern: String) {
    YYYY_MM_DD("yyyy/MM/dd"),
    YYYY_MM_DD_NO_SPLIT("yyyyMMdd")
}