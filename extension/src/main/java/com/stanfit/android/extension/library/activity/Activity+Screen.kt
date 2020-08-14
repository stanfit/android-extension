package com.stanfit.android.extension.library.activity

import android.app.Activity
import android.graphics.Point
import android.graphics.Rect
import android.util.Size

/**
 * Screen content size.
 * Not include status bar and navigation bar.
 *
 * example: 1080x1300
 */
val Activity.contentSize: Size
    @androidx.annotation.Size
    get() {
        val size = Rect()
        window.decorView.getWindowVisibleDisplayFrame(size)
        return Size(size.width(), size.height())
    }

/**
 * Screen resolution size.
 *
 * example: 1080x1920
 */
val Activity.resolutionSize: Size
    @androidx.annotation.Size
    get() {
        val size = Point()
        windowManager.defaultDisplay.getRealSize(size)
        return Size(size.x, size.y)
    }