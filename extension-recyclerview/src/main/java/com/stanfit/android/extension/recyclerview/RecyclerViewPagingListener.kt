package com.stanfit.android.extension.recyclerview

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * RecyclerView Paging Listener
 */
class RecyclerViewPagingListener(
    layoutManager: RecyclerView.LayoutManager,
    direction: RecyclerViewPagingDirection
) : RecyclerView.OnScrollListener() {

    /**
     * Additional loading listener
     */
    private var onLoadMoreListener: ((page: Int, total: Int) -> Unit)? = null

    /**
     * Number of pages currently loaded
     */
    private var pendingCurrentPage = 0

    /**
     * Number of items currently loaded
     */
    private var pendingTotalItemCount = 0

    /**
     * Loading flag
     */
    private var loading = true

    /**
     * Direction to be detected
     */
    private val pendingDirection: RecyclerViewPagingDirection

    /**
     * LinearLayoutManager
     */
    private var pendingLinearLayoutManager: LinearLayoutManager? = null

    /**
     * GridLayoutManager
     */
    private var pendingGridLayoutManager: GridLayoutManager? = null

    /**
     * StaggeredGridLayoutManager
     */
    private var pendingStaggeredGridLayoutManager: StaggeredGridLayoutManager? = null

    init {
        // Do not cast onScrolled for performance
        when (layoutManager) {
            is LinearLayoutManager -> {
                pendingLinearLayoutManager = layoutManager
            }
            is GridLayoutManager -> {
                pendingGridLayoutManager = layoutManager
            }
            is StaggeredGridLayoutManager -> {
                pendingStaggeredGridLayoutManager = layoutManager
            }
            else -> {
                throw IllegalArgumentException("unsupported this layout manager.")
            }
        }
        pendingDirection = direction
    }

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        var lastVisibleItemPosition = 0
        var firstVisibleItemPosition = 0
        var totalItemCount = 0
        when {
            pendingLinearLayoutManager != null -> {
                val layoutManager = requireNotNull(pendingLinearLayoutManager)
                totalItemCount = layoutManager.itemCount
                lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            }
            pendingGridLayoutManager != null -> {
                val layoutManager = requireNotNull(pendingGridLayoutManager)
                totalItemCount = layoutManager.itemCount
                lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            }
            pendingStaggeredGridLayoutManager != null -> {
                val layoutManager = requireNotNull(pendingStaggeredGridLayoutManager)
                val lastVisibleItemPositions = layoutManager.findLastVisibleItemPositions(null)
                val firstVisibleItemPositions = layoutManager.findFirstVisibleItemPositions(null)
                totalItemCount = layoutManager.itemCount
                lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions)
                firstVisibleItemPosition = getFirstVisibleItem(firstVisibleItemPositions)
            }
        }
        when (pendingDirection) {
            RecyclerViewPagingDirection.BOTTOM -> {
                if (totalItemCount < pendingTotalItemCount) {
                    pendingCurrentPage = STARTING_PAGE_INDEX
                    pendingTotalItemCount = totalItemCount
                    if (totalItemCount == 0) {
                        loading = true
                    }
                }
                if (loading && totalItemCount > pendingTotalItemCount) {
                    loading = false
                    pendingTotalItemCount = totalItemCount
                }
                if (!loading && lastVisibleItemPosition + PREFETCH_ITEM_POSITION > totalItemCount) {
                    pendingCurrentPage++
                    onLoadMoreListener?.invoke(pendingCurrentPage, totalItemCount)
                    loading = true
                }
            }
            RecyclerViewPagingDirection.TOP -> {
                if (totalItemCount < pendingTotalItemCount) {
                    pendingCurrentPage = STARTING_PAGE_INDEX
                    pendingTotalItemCount = totalItemCount
                    if (totalItemCount == 0) {
                        loading = true
                    }
                }
                if (loading && totalItemCount > pendingTotalItemCount) {
                    loading = false
                    pendingTotalItemCount = totalItemCount
                }
                if (!loading && firstVisibleItemPosition < PREFETCH_ITEM_POSITION) {
                    pendingCurrentPage++
                    onLoadMoreListener?.invoke(pendingCurrentPage, totalItemCount)
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
     * Set additional loading listener.
     *
     * @param block Block syntax that tells you the current page count, the current item count
     */
    fun setOnLoadMoreListener(block: (page: Int, total: Int) -> Unit) {
        onLoadMoreListener = block
    }

    /**
     * Reset
     */
    fun reset() {
        pendingCurrentPage = 0
        pendingTotalItemCount = 0
    }

    companion object {
        /**
         * Start paged index.
         */
        private const val STARTING_PAGE_INDEX = 0

        /**
         * Prefetch position
         *
         * When set to "5"
         * If you have 100 items, it will start loading when you see 95.
         */
        private const val PREFETCH_ITEM_POSITION = 10
    }
}
