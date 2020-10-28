package com.stanfit.android.extension.library.context

import android.content.Context
import androidx.annotation.Px

/**
 * Convert dp to px.
 *
 * @param dp
 * @return float pixel
 */
@Px
fun Context.px(dp: Float): Float {
    val metrics = resources.displayMetrics
    return dp * metrics.density
}

/**
 * Convert pixel to dp.
 *
 * @param px
 * @return float dp
 */
fun Context.dp(@Px px: Int): Float {
    val metrics = resources.displayMetrics
    return px / metrics.density
}