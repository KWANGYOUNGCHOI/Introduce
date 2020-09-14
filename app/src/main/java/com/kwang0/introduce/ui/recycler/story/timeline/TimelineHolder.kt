package com.kwang0.introduce.ui.recycler.story.timeline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.kwang0.introduce.R
import com.kwang0.introduce.model.Timeline
import com.kwang0.introduce.ui.recycler.AbstractHolder
import com.kwang0.introduce.utils.IntentUtils
import com.kwang0.introduce.utils.ResUtils
import kotlinx.android.synthetic.main.holder_timeline.view.*

class TimelineHolder(itemView: View) : AbstractHolder(itemView) {

    fun bind(timeline: Timeline) {
        itemView.textTimelineContentsTitle.text = timeline.innerType.getTitle()
        itemView.textTimelineContentsDate.text = timeline.innerType.getDate()
        itemView.imageTimelineIcon.setImageDrawable(ResUtils.getDrawable(timeline.innerType.getIcon()))

        initExternal()

        val externalArray = timeline.innerType.getExternal()
        externalArray.forEachIndexed { i, url ->
            if (i > 3) { return@forEachIndexed }
            initExternalUrl(i, url)
        }
    }

    private fun initExternalUrl(i: Int, url: String) {
        if (url.isEmpty()) { return }
        when (i) {
            0 -> setExternalUrl(itemView.imageTimelineExternalWeb, url)
            1 -> setExternalUrl(itemView.imageTimelineExternalAos, url)
            2 -> setExternalUrl(itemView.imageTimelineExternalIos, url)
        }
    }

    private fun setExternalUrl(view: View, url: String) {
        itemView.layoutTimelineExternal.visibility = View.VISIBLE
        view.visibility = View.VISIBLE
        view.setOnClickListener { IntentUtils.startExternalBrowser(itemView.context, url) }
    }

    private fun initExternal() {
        itemView.layoutTimelineExternal.visibility = View.GONE
        itemView.imageTimelineExternalWeb.visibility = View.GONE
        itemView.imageTimelineExternalAos.visibility = View.GONE
        itemView.imageTimelineExternalIos.visibility = View.GONE
    }

    companion object {
        fun newInstance(parent: ViewGroup): TimelineHolder {
            return TimelineHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.holder_timeline, parent, false)
            )
        }
    }
}
