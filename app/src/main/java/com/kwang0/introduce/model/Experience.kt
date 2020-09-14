package com.kwang0.introduce.model

import com.kwang0.introduce.enum.ExperienceType
import com.kwang0.introduce.enum.StoryType

class Experience(val innerType: ExperienceType) : Story {
    override val type = StoryType.EXPERIENCE
}
