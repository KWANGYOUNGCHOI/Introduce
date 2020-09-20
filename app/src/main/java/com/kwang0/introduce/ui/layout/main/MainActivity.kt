package com.kwang0.introduce.ui.layout.main

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kwang0.introduce.R
import com.kwang0.introduce.common.Const
import com.kwang0.introduce.helper.AnimationListenerHelper
import com.kwang0.introduce.model.Story
import com.kwang0.introduce.ui.recycler.story.StoryAdapter
import com.kwang0.introduce.ui.recycler.story.StoryAdapterModel
import com.kwang0.introduce.utils.ResUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.*


class MainActivity : AppCompatActivity(), MainContract.View, StoryAdapterModel {
    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        typeWriterMainHeaderDescription.apply {
            setCallback {
                setKwang0Name()
                changeCardBackgroundColor()
            }
            text = ""
            animateText(ResUtils.getString("main.header.description"))
        }
        typeWriterMainStickyKwang0Name.apply {
            text = ""
        }
        scrollMainStickyHeader.apply {
            header = layoutMainStickyKwang0Name
        }
    }

    override fun onBackPressed() {
        if (fabMain.isFabMenuOpen) {
            fabMain.handleFabMenu()
        } else {
            super.onBackPressed()
        }
    }

    private fun setKwang0Name() {
        typeWriterMainStickyKwang0Name.animateText(ResUtils.getString("common.kwang0.name"))
    }

    private fun changeCardBackgroundColor() {
        val anim = ValueAnimator.ofFloat(0f, 1f) // animate from 0 to 1
        anim.interpolator = DecelerateInterpolator()
        anim.duration = 1500 // for 1500 ms
        anim.addUpdateListener { animation ->
            val lp: ViewGroup.LayoutParams = viewMainStickyKwang0Name.layoutParams as ViewGroup.LayoutParams
            lp.width = (cardMainStickyKwang0Name.width * animation.animatedFraction).toInt()
            viewMainStickyKwang0Name.layoutParams = lp
        }
        anim.addListener(object : AnimationListenerHelper{
            override fun onAnimationEnd(animation: Animator?) {
                presenter?.initMain()
            }
        })
        anim.start()
    }

    override fun setAdapter(stories: List<Story>) {
        val lm = LinearLayoutManager(this)
        recyclerMainSticky.apply {
            layoutManager = lm
            itemAnimator = null
            addOnScrollListener(object : RecyclerView.OnScrollListener() {

            })
            adapter = StoryAdapter(stories, this@MainActivity)
            notifyDataSetChanged()
        }
    }

    override fun scrollToTop() {
        layoutMainUnStickyHeader.also { header ->
            scrollMainStickyHeader.also { scrollView ->
                scrollView.smoothScrollTo(scrollView.scrollX, header.top)
            }
        }
    }
}
