package com.kwang0.introduce.helper

import android.text.TextUtils

object StringHelper {
    fun String.isEmpty(): Boolean {
        return TextUtils.isEmpty(this)
    }

    fun String.isNotEmpty(): Boolean {
        return !TextUtils.isEmpty(this)
    }
}
fun emptyString(): String { return "" }
