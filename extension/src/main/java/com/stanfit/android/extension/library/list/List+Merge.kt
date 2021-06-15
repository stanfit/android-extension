package com.stanfit.android.extension.library.list

/**
 * Merge at the beginning of the list.
 *
 * this = [1,2,3]
 * new = [2,3,4]
 * merge = [4,2,3] = [4] + [1,2,3] - [1]
 *
 * @param new List to merge
 * @return Merged list
 */
fun <T> List<T>.mergeToFirst(new: List<T>): List<T> {
    if (this.isEmpty()) return new
    if (new.isEmpty()) return this
    return (new - this) + this - (this - new)
}

/**
 * Merge at the end of the list.
 *
 * this = [1,2,3]
 * new = [2,3,4]
 * merge = [2,3,4] = [1,2,3] - [1] + [4]
 *
 * @param new List to merge
 * @return Merged list
 */
fun <T> List<T>.mergeToLast(new: List<T>): List<T> {
    if (this.isEmpty()) return new
    if (new.isEmpty()) return this
    return this - (this - new) + (new - this)
}