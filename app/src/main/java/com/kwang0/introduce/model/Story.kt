package com.kwang0.introduce.model

import com.kwang0.introduce.enum.StoryType

interface Story {
    val type: StoryType
    val title: String
}
