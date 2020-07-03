package com.stanfit.android.extension.library.view

import android.view.View
import android.view.animation.AnimationUtils

/**
 * Animate fade in.
 */
fun View.fadeIn() {
    val animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in)
    startAnimation(animation)
    visibility = View.VISIBLE
}

/**
 * Animate fade out.
 */
fun View.fadeOut() {
    val animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_out)
    startAnimation(animation)
    visibility = View.INVISIBLE
}