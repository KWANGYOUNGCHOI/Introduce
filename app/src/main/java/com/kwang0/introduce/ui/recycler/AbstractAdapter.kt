package com.kwang0.introduce.ui.recycler

import androidx.recyclerview.widget.RecyclerView

abstract class AbstractAdapter<VH: AbstractHolder> : RecyclerView.Adapter<VH>() {
    override fun onViewRecycled(holder: VH) {
        holder.recycled()
    }
}