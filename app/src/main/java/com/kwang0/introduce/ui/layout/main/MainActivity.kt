package com.kwang0.introduce.ui.layout.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.introduce.R
import com.kwang0.introduce.common.Const
import com.kwang0.introduce.utils.ResUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        typeWriterMainHeaderDescription.also {
            it.text = ""
            it.animateText(ResUtils.getString("main.header.description"))
        }
        textMainStickyKwang0Name.also {
            it.transitionName = Const.KWANG0_NAME_TRANSITION
        }
        scrollMainStickyHeader.also {
            it.header = layoutMainStickyKwang0Name
        }
    }

    override fun onBackPressed() {
        if (fabMain.isFabMenuOpen) {
            fabMain.handleFabMenu()
        } else {
            super.onBackPressed()
        }
    }
}
