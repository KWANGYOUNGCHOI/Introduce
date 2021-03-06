package com.kwang0.introduce.ui.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun recycled() {
        clear()
    }

    protected open fun clear() {
    }
}
