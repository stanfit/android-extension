package com.stanfit.android.extension.library.list

import org.junit.Assert
import org.junit.Test

class ListExtensionTest {

    @Test
    fun test_correct_mergeToFirst_isEqual() {
        // 追加/削除
        val value1 = listOf("1", "2", "3").mergeToFirst(listOf("2", "3", "4"))
        Assert.assertEquals(value1, listOf("4", "2", "3"))
        // 空配列
        val value2 = listOf<String>().mergeToFirst(listOf("1", "2", "3"))
        Assert.assertEquals(value2, listOf("1", "2", "3"))
        val value3 = listOf("1", "2", "3").mergeToFirst(listOf())
        Assert.assertEquals(value3, listOf<String>())
        // 順番維持
        val value4 = listOf("1", "2", "3").mergeToFirst(listOf("3", "2", "1"))
        Assert.assertEquals(value4, listOf("1", "2", "3"))
    }

    @Test
    fun test_correct_mergeToLast_isEqual() {
        // 追加/削除
        val value = listOf("1", "2", "3").mergeToLast(listOf("2", "3", "4"))
        Assert.assertEquals(value, listOf("2", "3", "4"))
        // 空配列
        val value2 = listOf<String>().mergeToFirst(listOf("1", "2", "3"))
        Assert.assertEquals(value2, listOf("1", "2", "3"))
        val value3 = listOf("1", "2", "3").mergeToFirst(listOf())
        Assert.assertEquals(value3, listOf<String>())
        // 順番維持
        val value4 = listOf("1", "2", "3").mergeToFirst(listOf("3", "2", "1"))
        Assert.assertEquals(value4, listOf("1", "2", "3"))
    }
}
