package com.stanfit.android.extension.library.nestedscrollview

import androidx.core.widget.NestedScrollView

/**
 * Set scroll state listener.
 *
 * @param bloc callback.
 */
inline fun NestedScrollView.setOnScrollViewStateListener(crossinline bloc: (NestedScrollViewState) -> Unit) {
    setOnScrollChangeListener { _, scrollX, scrollY, oldScrollX, oldScrollY ->
        // scroll y
        if (scrollY != oldScrollY) {
            when {
                // scroll to top
                scrollY < oldScrollY -> {
                    bloc(NestedScrollViewState.ScrollTop(scrollY, oldScrollY))
                }
                // scroll to bottom
                scrollY > oldScrollY -> {
                    bloc(NestedScrollViewState.ScrollBottom(scrollY, oldScrollY))
                }
            }
        }
        // scroll x
        if (scrollX != oldScrollX) {
            when {
                // scroll to right
                scrollX > oldScrollX -> {
                    bloc(NestedScrollViewState.ScrollRight(scrollX, oldScrollX))
                }
                // scroll to left
                scrollX < oldScrollX -> {
                    bloc(NestedScrollViewState.ScrollLeft(scrollX, oldScrollX))
                }
            }
        }
    }
}