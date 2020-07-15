package com.stanfit.android.extension.library.edittext

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Hide Keyboard and clear focus.
 */
fun EditText.hideKeyboard() {
    val manager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    manager.hideSoftInputFromWindow(windowToken, 0)
    clearFocus()
}

/**
 * Show Keyboard and request focus.
 */
fun EditText.showKeyboard() {
    if (requestFocus()) {
        val manager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
    }
}