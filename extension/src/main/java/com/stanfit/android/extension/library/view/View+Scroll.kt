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