package com.kwang0.introduce.ui.recycler.story.experience

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kwang0.introduce.R
import com.kwang0.introduce.model.Experience
import com.kwang0.introduce.ui.recycler.AbstractHolder
import com.kwang0.introduce.ui.recycler.story.StoryAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.holder_experience.view.*

class ExperienceHolder(itemView: View) : AbstractHolder(itemView) {

    fun bind(experience: Experience) {
        itemView.textExperienceHolderTitle.text = experience.innerType.getTitle()
        val lm = LinearLayoutManager(itemView.context)
        lm.orientation = LinearLayoutManager.HORIZONTAL
        itemView.recyclerExperienceHolder.apply {
            layoutManager = lm
            itemAnimator = null
            addOnScrollListener(object : RecyclerView.OnScrollListener() {

            })
            adapter = ExperienceAdapter(experience.innerType.getIcon())
        }
    }

    companion object {
        fun newInstance(parent: ViewGroup): ExperienceHolder {
            return ExperienceHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.holder_experience, parent, false)
            )
        }
    }
}
