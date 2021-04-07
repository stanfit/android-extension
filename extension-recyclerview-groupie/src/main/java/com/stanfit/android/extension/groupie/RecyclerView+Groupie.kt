package com.stanfit.android.extension.groupie

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter

/**
 * Set up a click listener for an item that has been set up as a Groupie adapter
 *
 * @param block Block
 */
inline fun <reified T : Group> RecyclerView.setGroupieOnItemClickListener(crossinline block: (T, View, Int) -> Unit) {
    val adapter = adapter
    if (adapter is GroupAdapter) {
        adapter.setOnItemClickListener { item, view ->
            val position = adapter.getAdapterPosition(item)
            if (item is T) block(item, view, position)
        }
    }
}

/**
 * Set up a long click listener for an item that has been set up as a Groupie adapter
 *
 * @param block Block
 */
inline fun <reified T : Group> RecyclerView.setGroupieOnItemLongClickListener(crossinline block: (T, View, Int) -> Boolean) {
    val adapter = adapter
    if (adapter is GroupAdapter) {
        adapter.setOnItemLongClickListener { item, view ->
            val position = adapter.getAdapterPosition(item)
            return@setOnItemLongClickListener if (item is T) block(item, view, position) else false
        }
    }
}