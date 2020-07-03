package com.stanfit.android.extension.library.view

import android.os.Handler
import android.view.View

/**
 * Disable the view for a certain amount of time in order to prevent consecutive hits.
 *
 * @param delayMillis Click disablement time (in milliseconds)
 */
fun View.pauseClickTimer(delayMillis: Long = 500) {
    isClickable = false
    Handler().postDelayed({ isClickable = true }, delayMillis)
}

/**
 * Click listeners to disable clicking on the View for a certain amount of time in order to prevent continuous hitting.
 *
 * @param block Unit
 */
inline fun View.setOnClickPauseListener(crossinline block: (View) -> Unit) {
    if (hasOnClickListeners()) {
        return
    }
    setOnClickListener {
        pauseClickTimer(500)
        block.invoke(it)
    }
}