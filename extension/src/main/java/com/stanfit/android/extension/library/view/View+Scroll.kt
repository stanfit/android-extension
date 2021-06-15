package com.stanfit.android.extension.library.view

import android.view.View

/**
 * Judge the top.
 *
 * @return Boolean
 */
fun View.isScrollTop(): Boolean {
    return !canScrollVertically(-1)
}

/**
 * Judge the bottom.
 *
 * @return Boolean
 */
fun View.isScrollBottom(): Boolean {
    return !canScrollVertically(1)
}

/**
 * Judge the left.
 *
 * @return Boolean
 */
fun View.isScrollLeft(): Boolean {
    return !canScrollHorizontally(1)
}

/**
 * Judge the right.
 *
 * @return Boolean
 */
fun View.isScrollRight(): Boolean {
    return !canScrollHorizontally(-1)
}

/**
 * Set scroll state listener.
 *
 * @param bloc callback.
 */
inline fun View.setOnScrollStateListener(crossinline bloc: (ScrollState) -> Unit) {
    setOnScrollChangeListener { _, scrollX, scrollY, oldScrollX, oldScrollY ->
        // scroll y
        if (scrollY != oldScrollY) {
            when {
                // scroll to top
                scrollY < oldScrollY -> {
                    bloc(ScrollState.ScrollTop(scrollY, oldScrollY))
                }
                // scroll to bottom
                scrollY > oldScrollY -> {
                    bloc(ScrollState.ScrollBottom(scrollY, oldScrollY))
                }
            }
        }
        // scroll x
        if (scrollX != oldScrollX) {
            when {
                // scroll to right
                scrollX > oldScrollX -> {
                    bloc(ScrollState.ScrollRight(scrollX, oldScrollX))
                }
                // scroll to left
                scrollX < oldScrollX -> {
                    bloc(ScrollState.ScrollLeft(scrollX, oldScrollX))
                }
            }
        }
    }
}

/**
 * Scroll state.
 */
sealed class ScrollState {

    /**
     * Scroll to top.
     *
     * @property scrollY new position.
     * @property oldScrollY old position.
     */
    data class ScrollTop(val scrollY: Int, val oldScrollY: Int) : ScrollState()

    /**
     * Scroll to bottom.
     *
     * @property scrollY new position.
     * @property oldScrollY old position.
     */
    data class ScrollBottom(val scrollY: Int, val oldScrollY: Int) : ScrollState()

    /**
     * Scroll to right.
     *
     * @property scrollX new position.
     * @property oldScrollX old position.
     */
    data class ScrollRight(val scrollX: Int, val oldScrollX: Int) : ScrollState()

    /**
     * Scroll to left.
     *
     * @property scrollX new position.
     * @property oldScrollX old position.
     */
    data class ScrollLeft(val scrollX: Int, val oldScrollX: Int) : ScrollState()
}
