package com.stanfit.android.extension.library.file

import android.graphics.BitmapFactory
import android.util.Size
import java.io.File

/**
 * Get image size.
 *
 * @return Size
 */
fun File.getImageSize(): Size {
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = true
    BitmapFactory.decodeFile(absolutePath, options)
    val imageWidth = options.outWidth
    val imageHeight = options.outHeight
    return Size(imageWidth, imageHeight)
}