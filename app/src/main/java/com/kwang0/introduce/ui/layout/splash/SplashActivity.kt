package com.kwang0.introduce.ui.layout.splash

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.introduce.R
import com.kwang0.introduce.helper.AnimationListenerHelper
import com.kwang0.introduce.ui.layout.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), SplashContract.View {

    var presenter: SplashContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter = SplashPresenter(this)

        lottieSplashKwang0.addAnimatorListener(object : AnimationListenerHelper{
            override fun onAnimationEnd(animation: Animator?) {
                presenter?.initSplash()
            }
        })
    }

    override fun startMain() {
        startActivity(Intent(this, MainActivity::class.java))
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}
