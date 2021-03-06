package com.stanfit.android.extension.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Set the view in an empty state.
 *
 * @param view View
 */
fun RecyclerView.setEmptyView(view: View) {
    val observer = RecyclerViewEmptyObserver(this, view)
    if (adapter == null) {
        throw IllegalStateException("not found adapter.")
    }
    adapter?.registerAdapterDataObserver(observer)
}