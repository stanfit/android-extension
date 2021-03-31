package com.stanfit.android.extension.library.fragment

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import java.io.Serializable

/**
 * Result to be notified to the transition source.
 */
interface NavResults : Serializable

/**
 * Set to notify the result to the transition source Fragment.
 *
 * When DialogFragment is set, the callback of the transition source will be called.
 *
 * @param T Result type
 * @param value Result value
 */
inline fun <reified T : NavResults> Fragment.setFragmentResult(value: T) {
    setFragmentResult(T::class.java.name, bundleOf(NavResults::class.java.name to value))
}

/**
 * Obtaining the result of the transition source Fragment by callback
 *
 * @param T Result type
 * @param onResult Post-acquisition processing
 */
inline fun <reified T : NavResults> Fragment.setFragmentResultListener(crossinline onResult: (result: T) -> Unit) {
    setFragmentResultListener(T::class.java.name) { _, bundle ->
        val result = bundle.getSerializable(NavResults::class.java.name)
        if (result is T) onResult(result)
    }
}