package com.stanfit.android.extension.time

import java.time.OffsetDateTime

/**
 * [OffsetDateTime] Unique format (staggered) definition.
 *
 * @property pattern Pattern
 */
enum class OffsetDateTimeFormat(val pattern: String) {
    YYYY_MM_DD_HH_MM_SS_XXXXX("yyyy/MM/dd HH:mm:ssxxxxx"),
    YYYY_MM_DD_HH_MM_SS_SSS_XXXXX("yyyy/MM/dd HH:mm:ss.SSSxxxxx")
}