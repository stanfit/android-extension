package com.stanfit.android.extension.recyclerview

import android.content.Context
import androidx.annotation.IntRange
import androidx.annotation.Px
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * LinearLayoutManager for faster loading.
 */
class RecyclerViewPrefetchLayoutManager : LinearLayoutManager {

    @Px
    private var prefetchScreenSize = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, orientation: Int, reverseLayout: Boolean) : super(
        context,
        orientation,
        reverseLayout
    )

    override fun getExtraLayoutSpace(state: RecyclerView.State?): Int {
        return prefetchScreenSize
    }

    /**
     * Set the size to read ahead
     *
     * @param size Int
     */
    fun setPrefetchSize(@Px @IntRange(from = 1) size: Int) {
        prefetchScreenSize = size
    }
}
