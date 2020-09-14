package com.kwang0.introduce.enum

import com.kwang0.introduce.R
import com.kwang0.introduce.common.Const
import com.kwang0.introduce.helper.emptyString
import com.kwang0.introduce.utils.ResUtils

enum class TimelineType {
    UNIVERSITY,
    MILITARY,
    STUDENT_PRESIDENT,
    COMPANY_BUTAKE,
    COMPANY_WEMEET,
    COMPANY_CHANNEL;

    fun getTitle(): String {
        return when(this) {
            UNIVERSITY -> ResUtils.getString("main.timeline.title.university")
            MILITARY -> ResUtils.getString("main.timeline.title.military")
            STUDENT_PRESIDENT -> ResUtils.getString("main.timeline.title.student.president")
            COMPANY_BUTAKE -> ResUtils.getString("main.timeline.title.company.butake")
            COMPANY_WEMEET -> ResUtils.getString("main.timeline.title.company.wemeet")
            COMPANY_CHANNEL -> ResUtils.getString("main.timeline.title.company.channel")
        }
    }

    fun getDate(): String {
        return when(this) {
            UNIVERSITY -> ResUtils.getString("main.timeline.date.university")
            MILITARY -> ResUtils.getString("main.timeline.date.military")
            STUDENT_PRESIDENT -> ResUtils.getString("main.timeline.date.student.president")
            COMPANY_BUTAKE -> ResUtils.getString("main.timeline.date.company.butake")
            COMPANY_WEMEET -> ResUtils.getString("main.timeline.date.company.wemeet")
            COMPANY_CHANNEL -> ResUtils.getString("main.timeline.date.company.channel")
        }
    }

    fun getIcon(): Int {
        return when(this) {
            UNIVERSITY -> R.drawable.image_ynu
            MILITARY -> R.drawable.image_military
            STUDENT_PRESIDENT -> R.drawable.image_ynu
            COMPANY_BUTAKE -> R.drawable.image_butake
            COMPANY_WEMEET -> R.drawable.image_wemeet
            COMPANY_CHANNEL -> R.drawable.image_channel
        }
    }

    fun getExternal(): Array<String> {
        return when(this) {
            UNIVERSITY -> arrayOf(Const.EXTERNAL_YNU_WEB, emptyString(), emptyString())
            MILITARY -> arrayOf(emptyString(), emptyString(), emptyString())
            STUDENT_PRESIDENT -> arrayOf(Const.EXTERNAL_YNU_WEB, emptyString(), emptyString())
            COMPANY_BUTAKE -> arrayOf(Const.EXTERNAL_BUTAKE_WEB, Const.EXTERNAL_BUTAKE_AOS, Const.EXTERNAL_BUTAKE_IOS)
            COMPANY_WEMEET -> arrayOf(Const.EXTERNAL_WEMEET_WEB, Const.EXTERNAL_WEMEET_AOS, Const.EXTERNAL_WEMEET_IOS)
            COMPANY_CHANNEL -> arrayOf(Const.EXTERNAL_CHANNEL_WEB, Const.EXTERNAL_CHANNEL_AOS, Const.EXTERNAL_CHANNEL_IOS)
        }
    }
}
