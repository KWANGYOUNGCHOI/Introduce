package com.kwang0.introduce.enum

enum class StoryType(private val value: Int) {
    EXPERIENCE(0),
    TIMELINE(1),
    MOVETOP(2),
    UNKNOWN(9999);

    fun toInt(): Int {
        return value
    }

    companion object {
        fun fromId(id: Int): StoryType {
            for (type in values()) {
                if (type.toInt() == id) {
                    return type
                }
            }
            return UNKNOWN
        }
    }
}
