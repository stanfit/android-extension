package com.stanfit.android.extension.recyclerview

import androidx.recyclerview.widget.RecyclerView

/**
 * Paging listener pending.
 */
private val pagingListeners = mutableMapOf<Int, RecyclerViewPagingListener>()

/**
 * Add paging listener.
 *
 * @param initialPage initial paging index.
 * @param visibleThreshold item count to prefetch.
 * @param direction scroll direction.
 * @param block when load more, this block function called.
 */
fun RecyclerView.addOnPagingListener(
    initialPage: Int = 0,
    visibleThreshold: Int = 10,
    direction: RecyclerViewPagingListener.LoadOnScrollDirection = RecyclerViewPagingListener.LoadOnScrollDirection.BOTTOM,
    block: (page: Int, total: Int) -> Unit
) {
    if (isNestedScrollingEnabled.not()) throw IllegalStateException("not supported nested scroll.")
    val listener = RecyclerViewPagingListener(initialPage, visibleThreshold, direction)
    pagingListeners[id] = listener
    listener.setOnLoadMoreListener(block)
    addOnScrollListener(listener)
}

/**
 * Remove paging listener.
 */
fun RecyclerView.removeOnPagingListener() {
    val listener = pagingListeners[id] ?: return
    pagingListeners.remove(id)
    listener.reset()
    removeOnScrollListener(listener)
}