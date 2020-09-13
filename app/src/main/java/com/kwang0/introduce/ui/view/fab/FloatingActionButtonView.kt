package com.kwang0.introduce.ui.view.fab

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.OvershootInterpolator
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import com.kwang0.introduce.R
import com.kwang0.introduce.utils.IntentUtils
import com.kwang0.introduce.utils.ResUtils
import kotlinx.android.synthetic.main.view_floating_action_button.view.*

class FloatingActionButtonView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr)  {
    private var fabChildMenu = emptyList<View>()

    private var fabOpenAnimation: Animation? = null
    private var fabCloseAnimation: Animation? = null

    var isFabMenuOpen = false

    init {
        LayoutInflater.from(context).inflate(R.layout.view_floating_action_button, this, true)

        fabChildMenu = arrayListOf<View>(
            fabBlog,
            fabGithub,
            fabPlayStore
        )

        fabOpenAnimation = ResUtils.getAnimation("fab_open_menu")
        fabCloseAnimation = ResUtils.getAnimation("fab_close_menu")

        fabBase.setOnClickListener {
            handleFabMenu()
        }
    }

    fun handleFabMenu() {
        if (!isFabMenuOpen) {
            expandFabMenu()
        } else {
            collapseFabMenu()
        }
    }

    private fun expandFabMenu() {
        ViewCompat.animate(fabBase)
            .rotation(135.0f)
            .withLayer()
            .setDuration(300)
            .setInterpolator(OvershootInterpolator(10f))
            .start()
        
        setExpandChildMenu()

        isFabMenuOpen = true
    }

    private fun collapseFabMenu() {
        ViewCompat.animate(fabBase)
            .rotation(0f)
            .withLayer()
            .setDuration(300)
            .setInterpolator(OvershootInterpolator(10f))
            .start()

        setCollapseChildMenu()

        isFabMenuOpen = false
    }

    private fun setExpandChildMenu() {
        fabChildMenu.forEach { child ->
            child.startAnimation(fabOpenAnimation)
            child.setOnClickListener {
                val tag = it.tag
                if (tag is String && !TextUtils.isEmpty(tag)) {
                    IntentUtils.startExternalBrowser(context, tag)
                }
            }
        }
    }

    private fun setCollapseChildMenu() {
        fabChildMenu.forEach { child ->
            child.startAnimation(fabCloseAnimation)
            child.setOnClickListener { }
        }
    }
}
