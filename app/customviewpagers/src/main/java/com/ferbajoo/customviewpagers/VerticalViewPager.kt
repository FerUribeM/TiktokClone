package com.ferbajoo.customviewpagers

import android.content.Context
import android.util.AttributeSet
import android.util.Log.e
import android.view.MotionEvent
import android.view.View
import androidx.viewpager.widget.ViewPager

/**
 * Created by mohit on 1/1/17.
 *
 */
class VerticalViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    private val TAG = VerticalViewPager::class.java.simpleName

    private var swipe = true

    private fun swapXY(event: MotionEvent): MotionEvent? {
        val newX = event.y
        val newY = event.x
        event.setLocation(newX, newY)
        return event
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        e("Fragment: ", "Es: $swipe")
        return if (swipe) {
            val intercept = super.onInterceptTouchEvent(swapXY(ev!!))
            swapXY(ev)
            intercept
        } else {
            false
        }
    }

    /**
     *  disable and enable vertical swipe
     */
    fun setEnableSwipe(swipe: Boolean) {
        this.swipe = swipe
        e("setEnableSwipe: ", "Es: ${this.swipe}")
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return super.onTouchEvent(swapXY(ev!!))
    }

    init {
        setPageTransformer(true, VerticalViewPagerTransform())
        overScrollMode = View.OVER_SCROLL_NEVER
    }

    private class VerticalViewPagerTransform : PageTransformer {
        override fun transformPage(
            page: View,
            position: Float
        ) {
            when {
                position < -1 -> {
                    page.alpha = 0f
                }
                position <= 0 -> {
                    page.alpha = 1f
                    page.translationX = page.width * -position
                    page.translationY = page.height * position
                    page.scaleX = 1f
                    page.scaleY = 1f
                }
                position <= 1 -> {
                    page.alpha = 1 - position
                    page.translationX = page.width * -position
                    page.translationY = 0f
                    val scaleFactor =
                        Min_Scale + (1 - Min_Scale) * (1 - Math.abs(
                            position
                        ))
                    page.scaleX = scaleFactor
                    page.scaleY = scaleFactor
                }
                position > 1 -> {
                    page.alpha = 0f
                }
            }
        }

        companion object {
            private const val Min_Scale = 0.65f
        }
    }

}