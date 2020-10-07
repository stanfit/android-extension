package com.stanfit.android.extension.groupie

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

/**
 * Adapter of groupie
 */
val groupAdapter get() = GroupAdapter<GroupieViewHolder>()

/**
 * Get adapter of groupie
 *
 * @return GroupAdapter
 */
val RecyclerView.groupieAdapter: GroupAdapter<*>
    get() {
        val adapter = adapter
        if (adapter is GroupAdapter) {
            return adapter
        }
        throw IllegalAccessException("don't have adapter.")
    }

/**
 * Set up a click listener for an item that has been set up as a Groupie adapter
 *
 * @param block Block
 */
inline fun <reified T : Group> RecyclerView.setGroupieOnItemClickListener(crossinline block: (T, View) -> Unit) {
    val adapter = adapter
    if (adapter is GroupAdapter) {
        adapter.setOnItemClickListener { item, view ->
            if (item is T) block(item, view)
        }
    }
}

/**
 * Set up a long click listener for an item that has been set up as a Groupie adapter
 *
 * @param block Block
 */
inline fun <reified T : Group> RecyclerView.setGroupieOnItemLongClickListener(crossinline block: (T, View) -> Boolean) {
    val adapter = adapter
    if (adapter is GroupAdapter) {
        adapter.setOnItemLongClickListener { item, view ->
            return@setOnItemLongClickListener if (item is T) block(item, view) else false
        }
    }
}