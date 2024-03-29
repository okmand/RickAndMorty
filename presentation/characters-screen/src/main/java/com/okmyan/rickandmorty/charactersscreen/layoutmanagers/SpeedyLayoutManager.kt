package com.okmyan.rickandmorty.charactersscreen.layoutmanagers

import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

class SpeedyLinearLayoutManager : LinearLayoutManager {

    constructor(context: Context) : super(context)

    constructor(
        context: Context?,
        orientation: Int,
        reverseLayout: Boolean
    ) : super(context, orientation, reverseLayout)

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun smoothScrollToPosition(
        recyclerView: RecyclerView?, state: RecyclerView.State?, position: Int
    ) {
        val linearSmoothScroller = object : LinearSmoothScroller(recyclerView?.context) {

            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics?): Float {
                return displayMetrics?.densityDpi?.let {
                    MILLISECONDS_PER_INCH / it
                } ?: super.calculateSpeedPerPixel(displayMetrics)
            }

        }

        linearSmoothScroller.targetPosition = position
        startSmoothScroll(linearSmoothScroller)
    }

    companion object {
        private const val MILLISECONDS_PER_INCH = 5f
    }

}
