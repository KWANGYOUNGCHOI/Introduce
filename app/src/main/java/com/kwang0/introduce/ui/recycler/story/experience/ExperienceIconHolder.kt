package com.kwang0.introduce.ui.recycler.story.experience

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kwang0.introduce.R
import com.kwang0.introduce.utils.ResUtils
import kotlinx.android.synthetic.main.holder_experience_image.view.*

class ExperienceIconHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(icon: Int) {
        itemView.iconExperienceHolderImage.setImageDrawable(ResUtils.getDrawable(icon))
    }

    companion object {
        fun newInstance(parent: ViewGroup): ExperienceIconHolder {
            return ExperienceIconHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.holder_experience_image, parent, false)
            )
        }
    }
}