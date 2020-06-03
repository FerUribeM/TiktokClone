package com.ferbajoo.customviewpagers

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager.widget.ViewPager

/**
 * Created by Fernando U on 6/2/20.
 */

class HorizontalViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    override fun canScrollVertically(direction: Int): Boolean {
        return false
    }

    override fun canScrollHorizontally(direction: Int): Boolean {
        return false
    }

}