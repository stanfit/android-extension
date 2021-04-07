package com.stanfit.android.extension.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.findView(position: Int): View? {
    val manager = layoutManager ?: throw IllegalStateException("not found layout manager.")
    return manager.findViewByPosition(position)
}