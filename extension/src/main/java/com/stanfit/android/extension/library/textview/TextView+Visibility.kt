package com.stanfit.android.extension.library.textview

import android.widget.TextView
import androidx.core.view.isGone

/**
 * Set text and if text is empty to gone.
 *
 * @param text content text.
 */
fun TextView.setTextEmptyGone(text: String?) {
    this.text = text
    isGone = text.isNullOrEmpty()
}