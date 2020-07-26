package com.stanfit.android.extension.recyclerview

import androidx.recyclerview.widget.RecyclerView

/**
 * Paging listener pending.
 */
private val pagingListeners = mutableMapOf<Int, RecyclerViewPagingListener>()

/**
 * Add paging listener.
 *
 * @param direction scroll direction.
 * @param block paging listener.
 */
fun RecyclerView.addOnPagingListener(
    direction: RecyclerViewPagingDirection,
    block: (page: Int, total: Int) -> Unit
) {
    val manager = layoutManager ?: throw IllegalStateException("not found layout manager.")
    if (isNestedScrollingEnabled.not()) throw IllegalStateException("not supported nested scroll.")
    val listener = RecyclerViewPagingListener(manager, direction)
    pagingListeners[id] = listener
    listener.setOnLoadMoreListener(block)
    addOnScrollListener(listener)
}

/**
 * Remove paging listener.
 */
fun RecyclerView.removeOnPagingListener() {
    val listener = pagingListeners[id] ?: throw IllegalStateException("not found paging listener.")
    pagingListeners.remove(id)
    listener.reset()
    removeOnScrollListener(listener)
}