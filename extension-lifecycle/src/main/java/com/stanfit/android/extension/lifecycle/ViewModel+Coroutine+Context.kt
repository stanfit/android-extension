package com.stanfit.android.extension.lifecycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.coroutines.CoroutineContext

/**
 * Get coroutine context.
 */
val ViewModel.coroutineContext: CoroutineContext
    get() = viewModelScope.coroutineContext
