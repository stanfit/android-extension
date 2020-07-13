package com.stanfit.android.extension.library.context

import android.content.Context
import android.content.res.Configuration
import androidx.annotation.Px

/**
 * Get screen width.
 */
val Context.screenWidth: Int
    @Px
    get() {
        return resources.displayMetrics.widthPixels
    }

/**
 * Get screen height.
 */
val Context.screenHeight: Int
    @Px
    get() {
        return resources.displayMetrics.heightPixels
    }

/**
 * Check screen direction.
 *
 * @return Boolean
 */
fun Context.isPortrait(): Boolean {
    return resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
}

/**
 * Check screen direction.
 *
 * @return Boolean
 */
fun Context.isLandscape(): Boolean {
    return resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}

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