package com.kwang0.introduce.model

import com.kwang0.introduce.enum.StoryType
import com.kwang0.introduce.enum.TimelineType

class Timeline(val innerType: TimelineType) : Story {
    override val type = StoryType.TIMELINE
}
