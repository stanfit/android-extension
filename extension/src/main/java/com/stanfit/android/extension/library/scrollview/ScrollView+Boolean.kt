package com.stanfit.android.extension.library.scrollview

import android.widget.ScrollView

/**
 * Judge the top.
 *
 * @return Boolean
 */
fun ScrollView.isTop(): Boolean {
    return !canScrollVertically(-1)
}

/**
 * Judge the bottom.
 *
 * @return Boolean
 */
fun ScrollView.isBottom(): Boolean {
    return !canScrollVertically(1)
}

/**
 * Judge the left.
 *
 * @return Boolean
 */
fun ScrollView.isLeft(): Boolean {
    return !canScrollHorizontally(1)
}

/**
 * Judge the right.
 *
 * @return Boolean
 */
fun ScrollView.isRight(): Boolean {
    return !canScrollHorizontally(-1)
}
