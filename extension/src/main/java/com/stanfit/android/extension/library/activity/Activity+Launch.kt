package com.stanfit.android.extension.library.activity

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import android.util.Log

private const val TAG = "Activity+Launch"

/**
 * Launch Browse App.
 *
 * @param uri Uri
 */
fun Activity.launchBrowse(uri: Uri?) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    } catch (e: Exception) {
        Log.e(TAG, "failure launch web browse.", e)
    }
}

/**
 * Launch Browse App.
 *
 * @param url String
 */
fun Activity.launchBrowse(url: String?) {
    try {
        val uri = Uri.parse(url)
        launchBrowse(uri)
    } catch (e: Exception) {
        Log.e(TAG, "failure launch web browse.", e)
    }
}

/**
 * Launch Camera App.
 *
 * @param requestCode Request code.
 */
fun Activity.launchCamera(requestCode: Int = 0) {
    if (!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
        Log.e(TAG, "this device not found camera.")
        return
    }
    try {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, requestCode)
    } catch (e: Exception) {
        Log.e(TAG, "failure launch camera.", e)
    }
}

/**
 * Launch Gallery App.
 *
 * @param requestCode Request code.
 */
fun Activity.launchGallery(requestCode: Int = 0) {
    try {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, requestCode)
    } catch (e: Exception) {
        Log.e(TAG, "failure launch gallery.", e)
    }
}

/**
 * Launch GooglePlay App.
 *
 * @param requestCode Request code.
 */
fun Activity.launchGooglePlay(requestCode: Int = 0) {
    try {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("market://details?id=$packageName")
        startActivityForResult(intent, requestCode)
    } catch (e: Exception) {
        Log.e(TAG, "failure launch google play.", e)
    }
}