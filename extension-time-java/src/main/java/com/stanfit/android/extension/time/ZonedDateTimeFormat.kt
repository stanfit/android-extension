package com.stanfit.android.extension.java.time

import java.time.ZonedDateTime

/**
 * [ZonedDateTime] Unique format (with time zone) definition.
 *
 * @property pattern Pattern
 */
enum class ZonedDateTimeFormat(val pattern: String) {
    YYYY_MM_DD_HH_MM_SS_VV("yyyy/MM/dd HH:mm:ss VV"),
    YYYY_MM_DD_HH_MM_SS_ZZZ("yyyy/MM/dd HH:mm:ss zzz"),
    YYYY_MM_DD_HH_MM_SS_SSS_VV("yyyy/MM/dd HH:mm:ss.SSS VV"),
    YYYY_MM_DD_HH_MM_SS_SSS_ZZZ("yyyy/MM/dd HH:mm:ss.SSS zzz")
}
