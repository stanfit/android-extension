package com.stanfit.android.extension.library.edittext

import android.content.Context
import android.os.Build
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Hide Keyboard and clear focus.
 */
fun EditText.hideKeyboard() {
    val manager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    manager.hideSoftInputFromWindow(windowToken, 0)
    clearFocus()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        return
    } else {
        // Before Android 27, you can't get out of EditText without focusing on another View.
        var parent = parent
        while (true) {
            if (parent is ViewGroup) {
                parent.isFocusable = true
                parent.isFocusableInTouchMode = true
                parent.requestFocus()
                break
            }
            parent = parent.parent
        }
    }
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