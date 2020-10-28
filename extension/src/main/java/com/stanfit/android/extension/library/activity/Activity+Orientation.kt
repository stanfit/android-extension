package com.stanfit.android.extension.library.activity

import android.app.Activity
import android.content.res.Configuration

/**
 * Check screen direction.
 */
val Activity.isPortrait: Boolean
    get() {
        return resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }

/**
 * Check screen direction.
 */
val Activity.isLandscape: Boolean
    get() {
        return resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    }