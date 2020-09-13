package com.kwang0.introduce.ui.layout.main

import android.os.Bundle
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.introduce.R
import com.kwang0.introduce.common.Const
import com.kwang0.introduce.utils.ResUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        typeWriterMainHeaderDescription.apply {
            setCallback { setHightLightKwang0Name() }
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

    private fun setHightLightKwang0Name() {
        val str = SpannableString(textMainStickyKwang0Name.getText())
        ResUtils.getColor("yellow_pastel")?.also {
            str.setSpan(BackgroundColorSpan(it), 0, str.length, 0)
        }
        textMainStickyKwang0Name.setSpannableText(str)
    }
}
