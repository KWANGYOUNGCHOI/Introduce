package com.kwang0.introduce.ui.view.typewriter

import android.content.Context
import android.os.Handler
import android.util.AttributeSet

class TypeWriterView : androidx.appcompat.widget.AppCompatTextView {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var callback: (() -> Unit)? = null
    private var typeText: CharSequence? = null
    private var typeIndex = 0
    private var typeDelay: Long = 100 // in ms
    private val typeHandler: Handler = Handler()

    private val characterAdder: Runnable = object : Runnable {
        override fun run() {
            text = typeText?.subSequence(0, typeIndex++)
            typeText?.also {
                if (typeIndex <= it.length) {
                    typeHandler.postDelayed(this, typeDelay)
                } else {
                    typeHandler.removeCallbacks(this)
                    callback?.invoke()
                }
            }
        }
    }

    fun setCallback(callback: () -> Unit) {
        this.callback = callback
    }

    fun animateText(txt: CharSequence?) {
        typeText = txt
        typeIndex = 0
        text = ""
        typeHandler.removeCallbacks(characterAdder)
        typeHandler.postDelayed(characterAdder, typeDelay)
    }
}
