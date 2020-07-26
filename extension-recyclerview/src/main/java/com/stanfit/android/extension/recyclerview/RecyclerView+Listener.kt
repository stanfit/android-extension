package com.stanfit.android.extension.recyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Set the listener to change the position of the item.
 *
 * @param bloc Position Change Listener.
 */
inline fun RecyclerView.setOnItemPositionChangeListener(crossinline bloc: (Int) -> Unit) {
    val manager = layoutManager ?: throw IllegalStateException("not found layout manager.")
    if (manager is LinearLayoutManager) {
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val position = manager.findFirstVisibleItemPosition()
                    bloc(position)
                }
            }
        })
    }
}