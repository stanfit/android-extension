package com.stanfit.android.extension.library.map

import org.junit.Assert
import org.junit.Test

class MapExtensionTest {

    @Test
    fun test_correct_merge_isEqual() {
        // 追加/削除
        val value1 = mapOf("1" to "a", "2" to "b", "3" to "c").merge(mapOf("2" to "b", "3" to "c", "4" to "d"))
        Assert.assertEquals(value1, mapOf("2" to "b", "3" to "c", "4" to "d"))
        // 空Map
        val value2 = mapOf("1" to "a", "2" to "b", "3" to "c").merge(mapOf())
        Assert.assertEquals(value2, mapOf<String, String>())
        val value3 = mapOf<String, String>().merge(mapOf("1" to "a", "2" to "b", "3" to "c"))
        Assert.assertEquals(value3, mapOf("1" to "a", "2" to "b", "3" to "c"))
    }
}