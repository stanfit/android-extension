package com.stanfit.android.extension.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Monitoring the Empty State of RecyclerView
 *
 * @property recyclerView RecyclerView
 * @property emptyView View to display if empty
 */
class RecyclerViewEmptyObserver(
    private val recyclerView: RecyclerView,
    private val emptyView: View
) : RecyclerView.AdapterDataObserver() {

    init {
        checkIfEmpty()
    }

    override fun onChanged() {
        checkIfEmpty()
    }

    override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
        checkIfEmpty()
    }

    override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
        checkIfEmpty()
    }

    /**
     * Switches the display state of the View by determining if it is empty.
     */
    private fun checkIfEmpty() {
        val adapter = recyclerView.adapter
        if (adapter != null) {
            val isEmpty = adapter.itemCount == 0
            emptyView.visibility = if (isEmpty) View.VISIBLE else View.GONE
            recyclerView.visibility = if (isEmpty) View.GONE else View.VISIBLE
        }
    }
}
