package com.stanfit.android.extension.library.textview

import android.view.View
import android.widget.TextView

/**
 * Set text and if text is empty to gone.
 *
 * @param text content text.
 */
fun TextView.setTextEmptyGone(text: String?) {
    this.text = text
    visibility = if (text.isNullOrEmpty()) {
        View.GONE
    } else {
        View.VISIBLE
    }
}