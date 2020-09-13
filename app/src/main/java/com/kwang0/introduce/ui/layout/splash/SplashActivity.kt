package com.kwang0.introduce.ui.layout.splash

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.introduce.R
import com.kwang0.introduce.common.Const
import com.kwang0.introduce.helper.AnimationListenerHelper
import com.kwang0.introduce.ui.layout.main.MainActivity
import com.kwang0.introduce.utils.IntentUtils
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
        lottieSplashKwang0.animate()
            .setDuration(500)
            .alpha(0.0f)
            .setListener(object : AnimationListenerHelper{
                override fun onAnimationEnd(animation: Animator?) {
                    setMainTransitionIntent()
                }
            })
    }

    private fun setMainTransitionIntent() {
        IntentUtils.startTransition(
            this,
            MainActivity::class.java,
            textSplashKwang0Name,
            Const.KWANG0_NAME_TRANSITION
        )
//        activity?.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}
