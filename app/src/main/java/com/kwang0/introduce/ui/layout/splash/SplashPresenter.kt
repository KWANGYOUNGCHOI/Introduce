package com.kwang0.introduce.ui.layout.splash

class SplashPresenter(private val view: SplashContract.View): SplashContract.Presenter {
    override fun initSplash() {
        view.startMain()
    }
}
