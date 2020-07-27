package com.stanfit.android.extension.recyclerview

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * Set the listener when position of the first item is changed.
 *
 * @param bloc Position Change Listener.
 */
fun RecyclerView.setFindFirstVisibleItemPositionChangeListener(bloc: (Int) -> Unit) {
    val manager = layoutManager ?: throw IllegalStateException("not found layout manager.")
    when (manager) {
        is LinearLayoutManager -> {
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
        is GridLayoutManager -> {
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
        is StaggeredGridLayoutManager -> {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val position = manager.findFirstVisibleItemPositions(null)
                        bloc(getFirstVisibleItem(position))
                    }
                }
            })
        }
    }
}

/**
 * Set the listener when position of the last item is changed.
 *
 * @param bloc Position Change Listener.
 */
fun RecyclerView.setFindLastVisibleItemPositionChangeListener(bloc: (Int) -> Unit) {
    val manager = layoutManager ?: throw IllegalStateException("not found layout manager.")
    when (manager) {
        is LinearLayoutManager -> {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val position = manager.findLastVisibleItemPosition()
                        bloc(position)
                    }
                }
            })
        }
        is GridLayoutManager -> {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val position = manager.findLastVisibleItemPosition()
                        bloc(position)
                    }
                }
            })
        }
        is StaggeredGridLayoutManager -> {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val position = manager.findLastVisibleItemPositions(null)
                        bloc(getLastVisibleItem(position))
                    }
                }
            })
        }
    }
}

private fun getFirstVisibleItem(firstVisibleItemPositions: IntArray): Int {
    var maxSize = 0
    for (i in firstVisibleItemPositions.indices) {
        if (i == 0) {
            maxSize = firstVisibleItemPositions[i]
        } else if (firstVisibleItemPositions[i] > maxSize) {
            maxSize = firstVisibleItemPositions[i]
        }
    }
    return maxSize
}

private fun getLastVisibleItem(lastVisibleItemPositions: IntArray): Int {
    var maxSize = 0
    for (i in lastVisibleItemPositions.indices) {
        if (i == 0) {
            maxSize = lastVisibleItemPositions[i]
        } else if (lastVisibleItemPositions[i] > maxSize) {
            maxSize = lastVisibleItemPositions[i]
        }
    }
    return maxSize
}