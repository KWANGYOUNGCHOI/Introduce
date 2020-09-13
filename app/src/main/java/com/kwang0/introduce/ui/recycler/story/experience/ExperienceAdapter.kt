package com.kwang0.introduce.ui.recycler.story.experience

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ExperienceAdapter(private val items: List<Int>): RecyclerView.Adapter<ExperienceIconHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceIconHolder {
        return ExperienceIconHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: ExperienceIconHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
