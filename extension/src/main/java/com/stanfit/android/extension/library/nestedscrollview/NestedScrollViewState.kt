package com.stanfit.android.extension.library.nestedscrollview

/**
 * Scroll state.
 */
sealed class NestedScrollViewState {

    /**
     * Scroll to top.
     *
     * @property scrollX new position.
     * @property oldScrollX old position.
     */
    data class ScrollTop(val scrollX: Int, val oldScrollX: Int) : NestedScrollViewState()

    /**
     * Scroll to bottom.
     *
     * @property scrollX new position.
     * @property oldScrollX old position.
     */
    data class ScrollBottom(val scrollX: Int, val oldScrollX: Int) : NestedScrollViewState()

    /**
     * Scroll to right.
     *
     * @property scrollY new position.
     * @property oldScrollY old position.
     */
    data class ScrollRight(val scrollY: Int, val oldScrollY: Int) : NestedScrollViewState()

    /**
     * Scroll to left.
     *
     * @property scrollY new position.
     * @property oldScrollY old position.
     */
    data class ScrollLeft(val scrollY: Int, val oldScrollY: Int) : NestedScrollViewState()
}
