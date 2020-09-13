package com.kwang0.introduce.ui.recycler.story.unknown

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kwang0.introduce.R
import com.kwang0.introduce.ui.recycler.AbstractHolder

class UnknownHolder(itemView: View) : AbstractHolder(itemView) {

    companion object {
        fun newInstance(parent: ViewGroup): UnknownHolder {
            return UnknownHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.holder_unknown, parent, false)
            )
        }
    }
}