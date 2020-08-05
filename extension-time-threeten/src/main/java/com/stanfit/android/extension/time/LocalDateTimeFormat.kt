package com.stanfit.android.extension.time

import java.time.LocalDateTime

/**
 * [LocalDateTime] and time Unique format definition.
 *
 * @property pattern Pattern
 */
enum class LocalDateTimeFormat(val pattern: String) {
    YYYY_MM_DD_HH_MM("yyyy/MM/dd HH:mm"),
    YYYY_MM_DD_HH_MM_SS("yyyy/MM/dd HH:mm:ss"),
    YYYY_MM_DD_HH_MM_SS_SSS("yyyy/MM/dd HH:mm:ss.SSS"),
    YYYY_MM_DD_HH_MM_NO_SPLIT("yyyyMMddHHmm"),
    YYYY_MM_DD_HH_MM_SS_NO_SPLIT("yyyyMMddHHmmss"),
    YYYY_MM_DD_HH_MM_SS_SSS_NO_SPLIT("yyyyMMddHHmmssSSS")
}