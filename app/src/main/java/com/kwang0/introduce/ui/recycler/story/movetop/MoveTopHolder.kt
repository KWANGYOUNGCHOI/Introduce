package com.kwang0.introduce.ui.recycler.story.movetop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kwang0.introduce.R
import com.kwang0.introduce.ui.recycler.AbstractHolder
import kotlinx.android.synthetic.main.holder_move_top.view.*

class MoveTopHolder(itemView: View, private val model: MoveTopAdapterModel) : AbstractHolder(itemView) {

    fun bind() {
        itemView.imageMoveTopIcon.setOnClickListener { model.scrollToTop() }
        itemView.textMoveTop.setOnClickListener { model.scrollToTop() }
    }

    companion object {
        fun newInstance(parent: ViewGroup, model: MoveTopAdapterModel): MoveTopHolder {
            return MoveTopHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.holder_move_top, parent, false),
                model
            )
        }
    }
}
