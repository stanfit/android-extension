package com.stanfit.android.extension.library.nestedscrollview

import androidx.core.widget.NestedScrollView

/**
 * Judge the top.
 *
 * @return Boolean
 */
fun NestedScrollView.isTop(): Boolean {
    return !canScrollVertically(-1)
}

/**
 * Judge the bottom.
 *
 * @return Boolean
 */
fun NestedScrollView.isBottom(): Boolean {
    return !canScrollVertically(1)
}

/**
 * Judge the left.
 *
 * @return Boolean
 */
fun NestedScrollView.isLeft(): Boolean {
    return !canScrollHorizontally(1)
}

/**
 * Judge the right.
 *
 * @return Boolean
 */
fun NestedScrollView.isRight(): Boolean {
    return !canScrollHorizontally(-1)
}
