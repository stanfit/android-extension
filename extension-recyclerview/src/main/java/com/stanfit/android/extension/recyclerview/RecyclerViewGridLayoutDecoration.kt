package com.stanfit.android.extension.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.annotation.Px
import androidx.recyclerview.widget.RecyclerView

/**
 * Set the item interval when GridLayoutManager is configured.
 *
 * @param span Span of recyclerview column.
 * @param space Space of grid.
 */
class RecyclerViewGridLayoutDecoration(
    private val span: Int,
    @Px private val space: Int
) : RecyclerView.ItemDecoration() {

    private var isNeedLeftSpacing = false

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val frameWidth = ((parent.width - space.toFloat() * (span - 1)) / span).toInt()
        val padding = parent.width / span - frameWidth
        val itemPosition = (view.layoutParams as RecyclerView.LayoutParams).viewAdapterPosition
        if (itemPosition < span) {
            outRect.top = 0
        } else {
            outRect.top = space
        }
        if (itemPosition % span == 0) {
            outRect.left = 0
            outRect.right = padding
            isNeedLeftSpacing = true
        } else if ((itemPosition + 1) % span == 0) {
            isNeedLeftSpacing = false
            outRect.right = 0
            outRect.left = padding
        } else if (isNeedLeftSpacing) {
            isNeedLeftSpacing = false
            outRect.left = space - padding
            if ((itemPosition + 2) % span == 0) {
                outRect.right = space - padding
            } else {
                outRect.right = space / 2
            }
        } else if ((itemPosition + 2) % span == 0) {
            isNeedLeftSpacing = false
            outRect.left = space / 2
            outRect.right = space - padding
        } else {
            isNeedLeftSpacing = false
            outRect.left = space / 2
            outRect.right = space / 2
        }
        outRect.bottom = 0
    }
}
