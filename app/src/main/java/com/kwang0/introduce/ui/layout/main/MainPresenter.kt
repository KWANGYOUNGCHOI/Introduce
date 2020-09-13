package com.kwang0.introduce.ui.layout.main

class MainPresenter(private val view: MainContract.View): MainContract.Presenter  {
    override fun initMain() {
        view.setAdapter(listOf())
    }
}
