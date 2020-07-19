package com.stanfit.android.extension.lifecycle

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Observes changes in LiveData. If it is null, it does not notify.
 *
 * @param T Type
 * @param owner LifecycleOwner
 * @param observer observer process.
 */
fun <T> LiveData<T>.observeNotNull(owner: LifecycleOwner, observer: (T) -> Unit) {
    val swapOwner = when {
        owner is Fragment && owner.view != null -> owner.viewLifecycleOwner
        else -> owner
    }
    observe(swapOwner, Observer {
        if (it != null) observer(it)
    })
}

/**
 * Observes changes in LiveData. If it is null, it notify.
 *
 * @param T Type
 * @param owner LifecycleOwner
 * @param observer observer process.
 */
fun <T> LiveData<T>.observeOrNull(owner: LifecycleOwner, observer: (T?) -> Unit) {
    val swapOwner = when {
        owner is Fragment && owner.view != null -> owner.viewLifecycleOwner
        else -> owner
    }
    observe(swapOwner, Observer {
        observer(it)
    })
}

/**
 * Observes changes in LiveData. If it is null, it does not notify. And only changed previous values.
 *
 * @param T Type
 * @param owner LifecycleOwner
 * @param observer observer process.
 */
fun <T> LiveData<T>.observeOnChangedNotNull(owner: LifecycleOwner, observer: (T) -> Unit) {
    val swapOwner = when {
        owner is Fragment && owner.view != null -> owner.viewLifecycleOwner
        else -> owner
    }
    var pending: T? = null
    observe(swapOwner, Observer {
        if (it == null) return@Observer
        if (pending != it) observer(it)
        pending = it
    })
}

/**
 * Observes changes in LiveData. If it is null, it notify. And only changed previous values.
 *
 * @param T Type
 * @param owner LifecycleOwner
 * @param observer observer process.
 */
fun <T> LiveData<T>.observeOnChangedOrNull(owner: LifecycleOwner, observer: (T?) -> Unit) {
    val swapOwner = when {
        owner is Fragment && owner.view != null -> owner.viewLifecycleOwner
        else -> owner
    }
    var pending: T? = null
    observe(swapOwner, Observer {
        if (pending != it) observer(it)
        pending = it
    })
}