package com.stanfit.android.extension.library.context

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.*
import androidx.core.content.ContextCompat

/**
 * Stringリソースを取得
 *
 * @param stringRes リソースID
 * @return String
 */
fun Context.string(@StringRes stringRes: Int): String {
    return getString(stringRes)
}

/**
 * Stringリソースを取得
 *
 * @param stringRes リソースID
 * @param formats 代入する文字
 * @return String
 */
fun Context.string(@StringRes stringRes: Int, vararg formats: String): String {
    return getString(stringRes, formats)
}

/**
 * Colorリソースを取得
 *
 * @param colorRes リソースID
 * @return Int
 */
fun Context.color(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(this, colorRes)
}

/**
 * Booleanリソースを取得
 *
 * @param boolRes リソースID
 * @return Boolean
 */
fun Context.bool(@BoolRes boolRes: Int): Boolean {
    return resources.getBoolean(boolRes)
}

/**
 * Intリソースを取得
 *
 * @param integerRes リソースID
 * @return Int
 */
fun Context.integer(@IntegerRes integerRes: Int): Int {
    return resources.getInteger(integerRes)
}

/**
 * Drawableリソースを取得
 *
 * @param drawableRes リソースID
 * @return Drawable
 */
fun Context.drawable(@DrawableRes drawableRes: Int): Drawable {
    return ContextCompat.getDrawable(this, drawableRes)!!
}