package com.stanfit.android.extension.library.context

import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import androidx.annotation.*
import androidx.core.content.ContextCompat

/**
 * Get string resource.
 *
 * @param resId resource id.
 * @return String
 */
fun Context.string(@StringRes resId: Int): String {
    return getString(resId)
}

/**
 * Get string resource.
 *
 * @param resId resource id.
 * @param formats 代入する文字
 * @return String
 */
fun Context.string(@StringRes resId: Int, vararg formats: String): String {
    return getString(resId, formats)
}

/**
 * Get color resource.
 *
 * @param resId resource id.
 * @return Int
 */
fun Context.color(@ColorRes resId: Int): Int {
    return ContextCompat.getColor(this, resId)
}

/**
 * Get boolean resource.
 *
 * @param resId resource id.
 * @return Boolean
 */
fun Context.bool(@BoolRes resId: Int): Boolean {
    return resources.getBoolean(resId)
}

/**
 * Get integer resource.
 *
 * @param resId resource id.
 * @return Int
 */
fun Context.integer(@IntegerRes resId: Int): Int {
    return resources.getInteger(resId)
}

/**
 * Get drawable resource.
 *
 * @param resId resource id.
 * @return Drawable
 */
fun Context.drawable(@DrawableRes resId: Int): Drawable {
    return ContextCompat.getDrawable(this, resId)!!
}
