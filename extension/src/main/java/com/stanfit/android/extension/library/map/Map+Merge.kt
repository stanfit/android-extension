package com.stanfit.android.extension.library.map

/**
 * Marge any map.
 *
 * this = {1:[], 2:[], 3:[]}
 * new = {2:[], 3:[], 4:[]}
 * merge = {2:[], 3:[], 4:[]} = {1:[], 2:[], 3:[]} - {1:[]} + {4:[]}
 *
 * @param new Map to merge
 * @return Merged map
 */
fun <K, V> Map<K, V>.merge(new: Map<K, V>): Map<K, V> {
    if (this.isEmpty()) return new
    if (new.isEmpty()) return this
    val additional: Map<K, V> = new - this.keys
    val removal: Map<K, V> = this - new.keys
    return this - removal.keys + additional
}