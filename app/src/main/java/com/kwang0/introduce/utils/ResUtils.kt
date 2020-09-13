package com.kwang0.introduce.utils

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.kwang0.introduce.R
import com.kwang0.introduce.common.App

object ResUtils {
    fun getString(key: String?): String {
        if (key == null) {
            return ""
        }

        try {
            App.appContext?.also {
                val resId: Int = it.resources.getIdentifier(key, "string", it.packageName)
                if (resId != 0) {
                    return it.resources.getString(resId)
                }
            }
        } catch (e: Exception) { }

        return key;
    }

    fun getAnimation(key: String?): Animation? {
        if (key == null) {
            return null
        }

        try {
            App.appContext?.also {
                val resId: Int = it.resources.getIdentifier(key, "anim", it.packageName)
                if (resId != 0) {
                    return AnimationUtils.loadAnimation(it, resId)
                }
            }
        } catch (e: Exception) { }

        return null
    }
}
