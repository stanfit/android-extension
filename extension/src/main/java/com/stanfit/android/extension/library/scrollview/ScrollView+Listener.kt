package com.stanfit.android.extension.library.scrollview

import android.widget.ScrollView

/**
 * Set scroll state listener.
 *
 * @param bloc callback.
 */
inline fun ScrollView.setOnScrollViewStateListener(crossinline bloc: (ScrollViewState) -> Unit) {
    setOnScrollChangeListener { _, scrollX, scrollY, oldScrollX, oldScrollY ->
        // scroll y
        if (scrollY != oldScrollY) {
            when {
                // scroll to top
                scrollY < oldScrollY -> {
                    bloc(ScrollViewState.ScrollTop(scrollY, oldScrollY))
                }
                // scroll to bottom
                scrollY > oldScrollY -> {
                    bloc(ScrollViewState.ScrollBottom(scrollY, oldScrollY))
                }
            }
        }
        // scroll x
        if (scrollX != oldScrollX) {
            when {
                // scroll to right
                scrollX > oldScrollX -> {
                    bloc(ScrollViewState.ScrollRight(scrollX, oldScrollX))
                }
                // scroll to left
                scrollX < oldScrollX -> {
                    bloc(ScrollViewState.ScrollLeft(scrollX, oldScrollX))
                }
            }
        }
    }
}