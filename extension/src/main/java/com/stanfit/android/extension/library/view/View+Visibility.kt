package com.stanfit.android.extension.library.view

import android.view.View
import androidx.core.view.isVisible

/**
 * Switch visible or gone
 */
fun View.toggleGone() {
    visibility = if (isVisible) View.GONE else View.VISIBLE
}

/**
 * Switch visible or invisible
 */
fun View.toggleInvisible() {
    visibility = if (isVisible) View.INVISIBLE else View.VISIBLE
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