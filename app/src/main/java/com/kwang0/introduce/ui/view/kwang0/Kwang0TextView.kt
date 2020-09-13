package com.kwang0.introduce.ui.view.kwang0

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.kwang0.introduce.R
import com.kwang0.introduce.utils.ResUtils
import kotlinx.android.synthetic.main.view_kwang0_name.view.*

class Kwang0TextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.view_kwang0_name, this, true)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        textKwang0Name.also {
            it.text = ResUtils.getString("common.kwang0.name")
        }
    }
}
