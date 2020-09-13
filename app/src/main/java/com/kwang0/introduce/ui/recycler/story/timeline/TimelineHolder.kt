package com.kwang0.introduce.ui.recycler.story.timeline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kwang0.introduce.R
import com.kwang0.introduce.model.Timeline
import com.kwang0.introduce.ui.recycler.AbstractHolder

class TimelineHolder(itemView: View) : AbstractHolder(itemView) {
    private var timeline: Timeline? = null

    fun bind(timeline: Timeline) {
        this.timeline = timeline
    }

    companion object {
        fun newInstance(parent: ViewGroup): TimelineHolder {
            return TimelineHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.holder_timeline, parent, false)
            )
        }
    }
}
