package com.kwang0.introduce.ui.view.scroll

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.view.ViewCompat
import androidx.core.widget.NestedScrollView

class StickyScrollView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : NestedScrollView(context, attrs, defStyleAttr), ViewTreeObserver.OnGlobalLayoutListener  {

    var header: View? = null
        set(value) {
            field = value
            field?.also {
                ViewCompat.setTranslationZ(it, 1f)
                it.setOnClickListener { _ ->
                    this.smoothScrollTo(scrollX, it.top)
                }
            }
        }
    private var mHeaderInitPosition = 0f

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        overScrollMode = View.OVER_SCROLL_NEVER
        viewTreeObserver.addOnGlobalLayoutListener(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewTreeObserver.removeOnGlobalLayoutListener(this)
    }

    override fun onGlobalLayout() {
        mHeaderInitPosition = header?.top?.toFloat() ?: 0f
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)

        if (t > mHeaderInitPosition) {
            stickHeader(t - mHeaderInitPosition)
        } else {
            freeHeader()
        }
    }

    private fun stickHeader(position: Float) {
        header?.translationY = position
    }

    private fun freeHeader() {
        header?.translationY = 0f
    }
}
