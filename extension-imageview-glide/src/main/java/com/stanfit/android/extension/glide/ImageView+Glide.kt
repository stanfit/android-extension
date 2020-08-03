package com.stanfit.android.extension.glide

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import java.io.File

/**
 * Set image with url.
 *
 * @param url image url.
 */
fun ImageView.setImageUrl(url: String?) {
    if (url.isNullOrEmpty()) {
        return
    }
    Glide.with(context)
        .load(url)
        .into(this)
}

/**
 * Set image with uri.
 *
 * @param uri image uri
 */
fun ImageView.setImageUri(uri: Uri?) {
    if (uri == null) {
        return
    }
    Glide.with(context)
        .load(uri)
        .into(this)
}

/**
 * Set image with url.
 *
 * @param file image file
 */
fun ImageView.setImageFile(file: File?) {
    if (file == null) {
        return
    }
    Glide.with(context)
        .load(file)
        .into(this)
}

/**
 * Set circle image with url.
 *
 * @param url image url.
 */
fun ImageView.setCircleImageUrl(url: String?) {
    if (url.isNullOrEmpty()) {
        return
    }
    Glide.with(context)
        .load(url)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}

/**
 * Set circle image with uri.
 *
 * @param uri image uri.
 */
fun ImageView.setCircleImageUri(uri: Uri?) {
    if (uri == null) {
        return
    }
    Glide.with(context)
        .load(uri)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}

/**
 * Set circle image with file.
 *
 * @param file image file
 */
fun ImageView.setCircleImageFile(file: File?) {
    if (file == null) {
        return
    }
    Glide.with(context)
        .load(file)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}

/**
 * Set original size image with url.
 *
 * @param url image url.
 */
fun ImageView.setOriginalImageUrl(url: String?) {
    if (url.isNullOrEmpty()) {
        return
    }
    Glide.with(context)
        .load(url)
        .apply(RequestOptions().override(Target.SIZE_ORIGINAL))
        .into(this)
}

/**
 * Clear image.
 */
fun ImageView.clear() {
    Glide.with(context).clear(this)
}