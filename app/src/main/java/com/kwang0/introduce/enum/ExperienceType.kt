package com.kwang0.introduce.enum

import com.kwang0.introduce.R
import com.kwang0.introduce.utils.ResUtils

enum class ExperienceType {
    LANGUAGE,
    EXPERIENCE,
    IDE,
    ETC;

    fun getTitle(): String {
        return when(this) {
            LANGUAGE -> ResUtils.getString("main.experience.language")
            EXPERIENCE -> ResUtils.getString("main.experience.experience")
            IDE -> ResUtils.getString("main.experience.ide")
            ETC -> ResUtils.getString("main.experience.etc")
        }
    }

    fun getIcon(): List<Int> {
        return when(this) {
            LANGUAGE -> listOf(R.drawable.ic_java, R.drawable.ic_kotlin, R.drawable.ic_swift, R.drawable.ic_javascript)
            EXPERIENCE -> listOf(R.drawable.ic_android, R.drawable.ic_apple, R.drawable.ic_react)
            IDE -> listOf(R.drawable.ic_android_studio, R.drawable.ic_xcode, R.drawable.ic_visual_studio_code)
            ETC -> listOf(R.drawable.ic_firebase, R.drawable.ic_sqlite, R.drawable.ic_github)
        }
    }
}
