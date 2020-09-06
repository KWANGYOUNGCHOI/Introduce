package com.kwang0.introduce.layout.splash

class SplashPresenter(private val view: SplashContract.View): SplashContract.Presenter {
    override fun initLoadSplash() {
        view.startMain()
    }
}
