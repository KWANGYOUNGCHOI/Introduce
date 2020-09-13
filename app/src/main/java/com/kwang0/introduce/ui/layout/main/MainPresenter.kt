package com.kwang0.introduce.ui.layout.main

import com.kwang0.introduce.enum.ExperienceType
import com.kwang0.introduce.enum.TimelineType
import com.kwang0.introduce.model.Experience
import com.kwang0.introduce.model.Story
import com.kwang0.introduce.model.Timeline
import com.kwang0.introduce.utils.ResUtils

class MainPresenter(private val view: MainContract.View): MainContract.Presenter  {
    override fun initMain() {
        val stories = arrayListOf<Story>()
        stories.add(Experience(ResUtils.getString("main.experience.language"), ExperienceType.LANGUAGE))
        stories.add(Experience(ResUtils.getString("main.experience.experience"), ExperienceType.EXPERIENCE))
        stories.add(Experience(ResUtils.getString("main.experience.ide"), ExperienceType.IDE))
        stories.add(Experience(ResUtils.getString("main.experience.etc"), ExperienceType.ETC))
        stories.add(Timeline(ResUtils.getString("main.experience.etc"), "", TimelineType.SCHOOL))
        stories.add(Timeline(ResUtils.getString("main.experience.etc"), "", TimelineType.SCHOOL))
        stories.add(Timeline(ResUtils.getString("main.experience.etc"), "", TimelineType.SCHOOL))
        view.setAdapter(stories)
    }
}
