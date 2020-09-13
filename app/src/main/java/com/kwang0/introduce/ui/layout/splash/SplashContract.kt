package com.kwang0.introduce.ui.layout.splash

interface SplashContract {
    interface View {
        fun startMain()
    }

    interface Presenter {
        fun initSplash()
    }
}
