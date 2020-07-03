package com.stanfit.android.extension.library.view

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Hide Keyboard and clear focus.
 */
fun View.hideKeyboard() {
    val manager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    manager.hideSoftInputFromWindow(windowToken, 0)
    clearFocus()
}

/**
 * Show Keyboard and request focus.
 */
fun View.showKeyboard() {
    if (requestFocus()) {
        val manager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
    }
}