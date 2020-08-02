package com.stanfit.android.extension.lifecycle

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

/**
 * Get application context.
 */
val AndroidViewModel.context: Context
    get() = getApplication<Application>().applicationContext