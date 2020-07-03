package com.stanfit.android.extension.material.appbarlayout

import androidx.annotation.FloatRange

/**
 * AppBarLayout state.
 */
sealed class AppBarLayoutScrollState {

    /**
     * Expanded state.
     */
    object Expanded : AppBarLayoutScrollState()

    /**
     * Collapsed state.
     */
    object Collapsed : AppBarLayoutScrollState()

    /**
     * Scrolling state.
     *
     * @property percentage scroll rate.
     */
    data class Scrolling(
        @FloatRange(from = 0.0, to = 1.0) val percentage: Float
    ) : AppBarLayoutScrollState()
}