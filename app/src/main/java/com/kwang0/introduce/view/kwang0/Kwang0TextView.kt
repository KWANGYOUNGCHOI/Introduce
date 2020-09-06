package com.kwang0.introduce.view.kwang0

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.kwang0.introduce.utils.ResUtils

class Kwang0TextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        text = ResUtils.getString("common.kwang0.name")
    }
}
