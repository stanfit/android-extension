package com.stanfit.android.extension.library.viewpager

import androidx.viewpager.widget.ViewPager

/**
 * Set listener changing page.
 *
 * @param bloc Unit
 */
inline fun ViewPager.setOnPageChangeListener(crossinline bloc: (Int) -> Unit) {
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
            // do nothing
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            // do nothing
        }

        override fun onPageSelected(position: Int) {
            bloc.invoke(position)
        }
    })
}