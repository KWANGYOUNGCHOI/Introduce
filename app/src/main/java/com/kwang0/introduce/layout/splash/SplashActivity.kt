package com.kwang0.introduce.layout.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kwang0.introduce.R

class SplashActivity : AppCompatActivity(), SplashContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun startMain() {
        
    }
}
