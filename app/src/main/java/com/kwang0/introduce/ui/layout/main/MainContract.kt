package com.kwang0.introduce.ui.layout.main

import com.kwang0.introduce.model.Story

interface MainContract {
    interface Presenter {
        fun initMain()
    }

    interface View {
        fun setAdapter(stories: List<Story>)
    }
}
