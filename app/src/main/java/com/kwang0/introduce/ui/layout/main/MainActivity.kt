package com.kwang0.introduce.ui.layout.main

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.introduce.R
import com.kwang0.introduce.common.Const
import com.kwang0.introduce.model.Story
import com.kwang0.introduce.utils.ResUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {
    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this).also {
            it.initMain()
        }

        typeWriterMainHeaderDescription.apply {
            setCallback { changeCardBackgroundColor() }
            text = ""
            animateText(ResUtils.getString("main.header.description"))
        }
        textMainStickyKwang0Name.apply {
            transitionName = Const.KWANG0_NAME_TRANSITION
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

    private fun changeCardBackgroundColor() {
        val anim = ValueAnimator.ofFloat(0f, 1f) // animate from 0 to 1
        anim.interpolator = DecelerateInterpolator()
        anim.duration = 1500 // for 1500 ms
        anim.addUpdateListener { animation ->
            val lp: ViewGroup.LayoutParams = viewMainStickyKwang0Name.layoutParams as ViewGroup.LayoutParams
            lp.width = (cardMainStickyKwang0Name.width * animation.animatedFraction).toInt()
            viewMainStickyKwang0Name.layoutParams = lp
        }
        anim.start()
    }

    override fun setAdapter(stories: List<Story>) {

    }
}
