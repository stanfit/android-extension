package com.stanfit.android.extension.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

/**
 * Converting LiveData to another LiveData.
 *
 * @param X Type before the change.
 * @param Y Type after the change.
 * @param func change process.
 */
fun <X, Y> LiveData<X>.map(func: (X) -> Y) = Transformations.map(this, func)

/**
 * Switching LiveData to another LiveData.
 *
 * @param X Type before the change.
 * @param Y Type after the change.
 * @param func change process.
 */
fun <X, Y> LiveData<X>.switchMap(func: (X) -> LiveData<Y>) = Transformations.switchMap(this, func)