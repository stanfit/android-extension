package com.stanfit.android.extension.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlin.experimental.ExperimentalTypeInference

/**
 * Create a fixed LiveData in the coroutine scope of the [ViewModel]
 *
 * @param T data
 * @param block process
 * @return LiveData
 */
@OptIn(ExperimentalTypeInference::class)
fun <T> ViewModel.viewModelLiveData(
    @BuilderInference block: suspend LiveDataScope<T>.() -> Unit
): LiveData<T> = liveData(context = coroutineContext, block = block)
