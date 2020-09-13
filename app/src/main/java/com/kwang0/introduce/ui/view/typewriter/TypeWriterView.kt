package com.kwang0.introduce.ui.view.typewriter

import android.content.Context
import android.os.Handler
import android.util.AttributeSet

class TypeWriterView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyleAttr) {
    private var typeText: CharSequence? = null
    private var typeIndex = 0
    private var typeDelay: Long = 150 // in ms
    private val typeHandler: Handler = Handler()

    private val characterAdder: Runnable = object : Runnable {
        override fun run() {
            text = typeText!!.subSequence(0, typeIndex++)
            if (typeIndex <= typeText!!.length) {
                typeHandler.postDelayed(this, typeDelay)
            }
        }
    }

    fun animateText(txt: CharSequence?) {
        typeText = txt
        typeIndex = 0
        text = ""
        typeHandler.removeCallbacks(characterAdder)
        typeHandler.postDelayed(characterAdder, typeDelay)
    }
}
