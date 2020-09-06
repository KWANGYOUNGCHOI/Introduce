package com.kwang0.introduce.layout.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kwang0.introduce.R
import com.kwang0.introduce.layout.main.MainActivity

class SplashActivity : AppCompatActivity(), SplashContract.View {

    var presenter: SplashContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter = SplashPresenter(this)
            .also {
                it.initSplash()
            }
    }

    override fun startMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }
}
