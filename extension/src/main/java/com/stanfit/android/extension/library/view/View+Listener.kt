package com.stanfit.android.extension.library.view

import android.view.View
import android.view.ViewTreeObserver

/**
 * Set callback after view measured.
 *
 * @param T View instance
 * @param bloc callback
 */
inline fun <T : View> T.addOnGlobalLayoutListener(crossinline bloc: T.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (measuredWidth > 0 && measuredHeight > 0) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                bloc()
            }
        }
    })
}