package com.stanfit.android.extension.library.view

import android.view.View

/**
 * Switch visible or gone
 */
fun View.toggleVisibleOrGone() {
    visibility = if (isVisible()) View.GONE else View.VISIBLE
}

/**
 * Switch visible or invisible
 */
fun View.toggleVisibleOrInvisible() {
    visibility = if (isVisible()) View.INVISIBLE else View.VISIBLE
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
fun View.isVisible(): Boolean {
    return visibility == View.VISIBLE
}

/**
 * Check view is invisible.
 *
 * @return Boolean
 */
fun View.isInvisible(): Boolean {
    return visibility == View.INVISIBLE
}

/**
 * Check view is gone.
 *
 * @return Boolean
 */
fun View.isGone(): Boolean {
    return visibility == View.GONE
}