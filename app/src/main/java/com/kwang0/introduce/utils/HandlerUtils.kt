package com.kwang0.introduce.utils

import android.os.Handler

object HandlerUtils {
    fun splashPostDelay(cb: () -> Unit) {
        Handler().postDelayed(cb, 1500)
    }
}
