package com.stanfit.android.extension.library.webview

import android.webkit.WebView

/**
 * Enable javascript.
 *
 * @param enabled Boolean
 */
fun WebView.setJavaScriptEnabled(enabled: Boolean?) {
    if (enabled == null) {
        return
    }
    settings.javaScriptEnabled = enabled
}