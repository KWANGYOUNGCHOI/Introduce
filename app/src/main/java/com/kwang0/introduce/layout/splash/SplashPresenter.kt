package com.kwang0.introduce.layout.splash

import com.kwang0.introduce.utils.HandlerUtils

class SplashPresenter(private val view: SplashContract.View): SplashContract.Presenter {
    override fun initSplash() {
        HandlerUtils.splashPostDelay { view.startMain() }
    }
}
