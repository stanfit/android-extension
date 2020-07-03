package com.stanfit.android.extension.library.file

import java.io.File

/**
 * Delete if exist.
 *
 * @return delete success flag.
 */
fun File.deleteIfExist(): Boolean = if (exists()) delete() else false