package com.kwang0.introduce.ui.recycler.story

import android.view.ViewGroup
import com.kwang0.introduce.enum.StoryType
import com.kwang0.introduce.model.Experience
import com.kwang0.introduce.model.MoveTop
import com.kwang0.introduce.model.Story
import com.kwang0.introduce.model.Timeline
import com.kwang0.introduce.ui.recycler.AbstractAdapter
import com.kwang0.introduce.ui.recycler.AbstractHolder
import com.kwang0.introduce.ui.recycler.story.experience.ExperienceHolder
import com.kwang0.introduce.ui.recycler.story.movetop.MoveTopAdapterModel
import com.kwang0.introduce.ui.recycler.story.movetop.MoveTopHolder
import com.kwang0.introduce.ui.recycler.story.timeline.TimelineHolder
import com.kwang0.introduce.ui.recycler.story.unknown.UnknownHolder

class StoryAdapter(private val items: List<Story>, private val model: StoryAdapterModel): AbstractAdapter<AbstractHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractHolder {
        return when (StoryType.fromId(viewType)) {
            StoryType.EXPERIENCE -> ExperienceHolder.newInstance(parent)
            StoryType.TIMELINE -> TimelineHolder.newInstance(parent)
            StoryType.MOVETOP -> MoveTopHolder.newInstance(parent, (model as MoveTopAdapterModel))
            else -> UnknownHolder.newInstance(parent)
        }
    }

    override fun onBindViewHolder(holder: AbstractHolder, position: Int) {
        val item = items[position]

        when (item.type) {
            StoryType.EXPERIENCE -> (item as? Experience)?.also { (holder as? ExperienceHolder)?.bind(it) }
            StoryType.TIMELINE -> (item as? Timeline)?.also { (holder as? TimelineHolder)?.bind(it) }
            StoryType.MOVETOP -> (item as? MoveTop)?.also { (holder as? MoveTopHolder)?.bind() }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items.get(position).type.toInt()
    }
}
