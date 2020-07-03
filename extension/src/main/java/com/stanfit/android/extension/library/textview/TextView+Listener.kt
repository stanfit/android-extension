package com.stanfit.android.extension.library.textview

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

/**
 * Set listener changing text.
 *
 * @param bloc Unit
 */
inline fun TextView.setOnChangedTextListener(crossinline bloc: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // do nothing
        }

        override fun afterTextChanged(s: Editable?) {
            // do nothing
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            bloc.invoke(s.toString())
        }
    })
}