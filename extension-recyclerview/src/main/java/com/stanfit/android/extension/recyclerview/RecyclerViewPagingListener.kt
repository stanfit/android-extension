package com.stanfit.android.extension.recyclerview

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * RecyclerView Paging Listener
 *
 * @property initialPage initial paging index.
 * @property visibleThreshold item count to prefetch.
 * @property direction scroll direction.
 */
class RecyclerViewPagingListener(
    private val initialPage: Int = 0,
    private val visibleThreshold: Int = 10,
    private val direction: LoadOnScrollDirection = LoadOnScrollDirection.BOTTOM
) : RecyclerView.OnScrollListener() {

    /**
     * Additional Reading Listener.
     */
    private var onLoadMoreListener: ((page: Int) -> Unit)? = null

    /**
     * Number of pages currently loaded.
     */
    private var pendingCurrentPage = initialPage

    /**
     * Number of items currently loaded.
     */
    private var pendingTotalItemCount = 0

    /**
     * Loading flag
     */
    private var loading = true

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        // ポジション計算
        val lastVisibleItemPosition: Int
        val firstVisibleItemPosition: Int
        val totalItemCount: Int
        when (val layoutManager = view.layoutManager) {
            is LinearLayoutManager -> {
                totalItemCount = layoutManager.itemCount
                lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            }
            is GridLayoutManager -> {
                totalItemCount = layoutManager.itemCount
                lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            }
            is StaggeredGridLayoutManager -> {
                val lastVisibleItemPositions = layoutManager.findLastVisibleItemPositions(null)
                val firstVisibleItemPositions = layoutManager.findFirstVisibleItemPositions(null)
                totalItemCount = layoutManager.itemCount
                lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions)
                firstVisibleItemPosition = getFirstVisibleItem(firstVisibleItemPositions)
            }
            else -> return
        }

        // ロード判定
        when (direction) {
            LoadOnScrollDirection.BOTTOM -> {
                if (totalItemCount < pendingTotalItemCount) {
                    pendingCurrentPage = initialPage
                    pendingTotalItemCount = totalItemCount
                    if (totalItemCount == 0) {
                        loading = true
                    }
                }
                if (loading && totalItemCount > pendingTotalItemCount) {
                    loading = false
                    pendingTotalItemCount = totalItemCount
                }
                if (!loading && lastVisibleItemPosition + visibleThreshold > totalItemCount) {
                    pendingCurrentPage++
                    onLoadMoreListener?.invoke(pendingCurrentPage)
                    loading = true
                }
            }
            LoadOnScrollDirection.TOP -> {
                if (totalItemCount < pendingTotalItemCount) {
                    pendingCurrentPage = initialPage
                    pendingTotalItemCount = totalItemCount
                    if (totalItemCount == 0) {
                        loading = true
                    }
                }
                if (loading && totalItemCount > pendingTotalItemCount) {
                    loading = false
                    pendingTotalItemCount = totalItemCount
                }
                if (!loading && firstVisibleItemPosition < visibleThreshold) {
                    pendingCurrentPage++
                    onLoadMoreListener?.invoke(pendingCurrentPage)
                    loading = true
                }
            }
        }
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

    /**
     * Set additional reading listener.
     *
     * @param block Block syntax to notify current page count, current item count.
     */
    fun setOnLoadMoreListener(block: (page: Int) -> Unit) {
        onLoadMoreListener = block
    }

    fun init(currentPage: Int) {
        pendingCurrentPage = currentPage
        onLoadMoreListener?.invoke(pendingCurrentPage)
    }

    fun set(currentPage: Int) {
        pendingCurrentPage = currentPage
    }

    /**
     * Scroll detection direction
     */
    enum class LoadOnScrollDirection {
        TOP, BOTTOM
    }
}