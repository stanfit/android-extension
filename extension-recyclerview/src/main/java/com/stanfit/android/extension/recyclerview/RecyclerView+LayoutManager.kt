package com.stanfit.android.extension.recyclerview

import androidx.annotation.Px
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Configure LinearLayoutManager.
 *
 * @param orientation Scroll orientation.
 * @param reverseLayout Whether to turn the data upside down.
 */
fun RecyclerView.setLinearLayoutManager(
    orientation: Int = RecyclerView.VERTICAL,
    reverseLayout: Boolean = false
) {
    layoutManager = LinearLayoutManager(context, orientation, reverseLayout)
}

/**
 * Configure LinearLayoutManager with divider.
 */
fun RecyclerView.setLinearLayoutManagerWithDivider() {
    val linearLayoutManager = LinearLayoutManager(context)
    layoutManager = linearLayoutManager
    val dividerItemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
    addItemDecoration(dividerItemDecoration)
}

/**
 * Configure Prefetch LinearLayoutManager.
 *
 * @param prefetchSize Load ahead size. default is
 * @param orientation Scroll orientation.
 * @param reverseLayout Whether to turn the data upside down.
 */
fun RecyclerView.setPrefetchLinearLayoutManager(
    prefetchSize: Int = context.resources.displayMetrics.heightPixels * 3,
    orientation: Int = RecyclerView.VERTICAL,
    reverseLayout: Boolean = false
) {
    layoutManager = RecyclerViewPrefetchLayoutManager(context, orientation, reverseLayout).apply {
        setPrefetchSize(prefetchSize)
    }
}

/**
 * Configure GridLayoutManager.
 *
 * @param span Span of recyclerview.
 */
fun RecyclerView.setGridLayoutManager(span: Int) {
    layoutManager = GridLayoutManager(context, span)
}

/**
 * Configure GridLayoutManager with divider.
 *
 * @param span Span of recyclerview.
 * @param space Item spacing.
 */
fun RecyclerView.setGridLayoutManagerWithDivider(span: Int, @Px space: Int) {
    val gridLayoutManager = GridLayoutManager(context, span)
    layoutManager = gridLayoutManager
    val dividerItemDecoration = RecyclerViewGridLayoutDecoration(gridLayoutManager.spanCount, space)
    addItemDecoration(dividerItemDecoration)
}