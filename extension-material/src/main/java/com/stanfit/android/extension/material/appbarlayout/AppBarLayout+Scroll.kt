package com.stanfit.android.extension.material.appbarlayout

import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

/**
 * Set scroll state listener.
 *
 * @param bloc callback.
 */
inline fun AppBarLayout.setOnChangedAppBarScrollStateListener(crossinline bloc: (AppBarLayoutScrollState) -> Unit) {
    var pendingPercentage = 1.0f
    addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
        when (abs(verticalOffset)) {
            0 -> {
                // Expanded
                bloc(AppBarLayoutScrollState.Expanded)
            }
            appBarLayout.totalScrollRange -> {
                // Collapsed
                bloc(AppBarLayoutScrollState.Collapsed)
            }
            else -> {
                // Scrolling
                val scrollPercentage =
                    1 - abs(verticalOffset / appBarLayout.totalScrollRange.toFloat())
                if (pendingPercentage != scrollPercentage) {
                    pendingPercentage = scrollPercentage
                    bloc(AppBarLayoutScrollState.Scrolling(scrollPercentage))
                }
            }
        }
    })
}