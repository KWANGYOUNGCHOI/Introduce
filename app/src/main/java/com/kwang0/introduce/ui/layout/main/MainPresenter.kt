package com.kwang0.introduce.ui.layout.main

import com.kwang0.introduce.enum.ExperienceType
import com.kwang0.introduce.enum.TimelineType
import com.kwang0.introduce.model.Experience
import com.kwang0.introduce.model.MoveTop
import com.kwang0.introduce.model.Story
import com.kwang0.introduce.model.Timeline
import com.kwang0.introduce.utils.ResUtils

class MainPresenter(private val view: MainContract.View): MainContract.Presenter  {
    override fun initMain() {
        val stories = arrayListOf<Story>()
        stories.add(Experience(ExperienceType.LANGUAGE))
        stories.add(Experience(ExperienceType.EXPERIENCE))
        stories.add(Experience(ExperienceType.TOOL))
        stories.add(Experience(ExperienceType.ETC))
        stories.add(Timeline(TimelineType.UNIVERSITY))
        stories.add(Timeline(TimelineType.MILITARY))
        stories.add(Timeline(TimelineType.STUDENT_PRESIDENT))
        stories.add(Timeline(TimelineType.COMPANY_BUTAKE))
        stories.add(Timeline(TimelineType.COMPANY_WEMEET))
        stories.add(Timeline(TimelineType.COMPANY_CHANNEL))
        stories.add(MoveTop())
        view.setAdapter(stories)
    }
}
