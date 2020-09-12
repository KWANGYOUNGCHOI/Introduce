package com.kwang0.introduce.utils

import android.util.Log
import com.kwang0.introduce.BuildConfig
import com.kwang0.introduce.common.Const

object LoggerUtils {
    private const val TAG = Const.TAG
    private val isDebug = BuildConfig.DEBUG

    fun e(message: String) {
        Log.e(TAG, message)
    }

    fun w(message: String) {
        Log.w(TAG, message)
    }

    fun d(message: String) {
        if (isDebug) {
            return
        }
        Log.d(TAG, message)
    }

    fun i(message: String) {
        if (isDebug) {
            return
        }
        Log.i(TAG, message)
    }

    fun v (message: String) {
        if (isDebug) {
            return
        }
        Log.v(TAG,message)
    }
}
