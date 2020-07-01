package com.stanfit.android.extension.library.view

import android.view.View

/**
 * Switch visible or gone
 */
fun View.toggleVisibleOrGone() {
    visibility = if (isShow()) View.GONE else View.VISIBLE
}

/**
 * Switch visible or invisible
 */
fun View.toggleVisibleOrInvisible() {
    visibility = if (isShow()) View.INVISIBLE else View.VISIBLE
}

/**
 * To visible.
 */
fun View.toVisible() {
    visibility = View.VISIBLE
}

/**
 * To invisible.
 */
fun View.toInvisible() {
    visibility = View.INVISIBLE
}

/**
 * To gone.
 */
fun View.toGone() {
    visibility = View.GONE
}

/**
 * Check view is visible.
 *
 * @return Boolean
 */
fun View.isShow(): Boolean {
    return visibility == View.VISIBLE
}

/**
 * Check view is not visible.
 *
 * @return Boolean
 */
fun View.isHide(): Boolean {
    return visibility == View.GONE || visibility == View.INVISIBLE
}