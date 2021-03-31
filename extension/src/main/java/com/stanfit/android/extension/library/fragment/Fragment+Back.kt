package com.stanfit.android.extension.library.fragment

import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment

/**
 * Back Processing
 * Implementation disables Activity back-processing.
 *
 * @param block when press back button, this function called.
 */
fun Fragment.onBackPressed(block: OnBackPressedCallback.() -> Unit) {
    activity?.onBackPressedDispatcher?.addCallback(this, true, block)
}