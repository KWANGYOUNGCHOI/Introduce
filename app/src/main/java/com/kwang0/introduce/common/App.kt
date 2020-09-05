package com.kwang0.introduce.common

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        appContext = this
    }

    companion object {
        var appContext: App? = null
    }
}
