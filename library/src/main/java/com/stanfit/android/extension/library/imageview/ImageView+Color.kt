package com.stanfit.android.extension.library.imageview

import android.content.res.ColorStateList
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat

/**
 * Set image tint color.
 *
 * @param color color int.
 */
fun ImageView.setTintColor(@ColorInt color: Int) {
    ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(color))
}

/**
 * Set image tint color.
 *
 * @param resId color resource id.
 */
fun ImageView.setTintColorRes(@ColorRes resId: Int) {
    val color = ContextCompat.getColor(context, resId)
    ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(color))
}