package com.kwang0.introduce.layout.splash

interface SplashContract {
    interface View {
        fun startMain()
    }

    interface Presenter {
        fun initLoadSplash()
    }
}
