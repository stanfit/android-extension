package com.stanfit.android.extension.library.view

import android.app.Activity
import android.content.ContextWrapper
import android.view.View

/**
 * Get Activity.
 */
val View.activity: Activity?
    get() {
        var context = context
        while (context is ContextWrapper) {
            if (context is Activity) {
                return context
            }
            context = context.baseContext
        }
        return null
    }