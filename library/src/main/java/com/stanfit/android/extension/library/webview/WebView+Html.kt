package com.stanfit.android.extension.library.webview

import android.webkit.WebView

/**
 * Set HTML to web view.
 *
 * @param data HTML
 */
fun WebView.setHtml(data: String?) {
    if (data == null) {
        return
    }
    loadDataWithBaseURL("", data, "text/html", "UTF-8", "")
}