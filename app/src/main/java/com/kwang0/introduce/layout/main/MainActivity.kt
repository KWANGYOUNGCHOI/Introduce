package com.kwang0.introduce.layout.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.introduce.R
import com.kwang0.introduce.utils.ResUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textMainHeaderDescription.also {
            it.text = ResUtils.getString("main.header.description")
        }
        scrollMainStickyHeader.also {
            it.header = layoutMainStickyKwang0Name
        }
    }
}
