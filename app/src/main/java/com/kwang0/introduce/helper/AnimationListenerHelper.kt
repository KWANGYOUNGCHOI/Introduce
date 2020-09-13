package com.kwang0.introduce.helper

import android.animation.Animator

interface AnimationListenerHelper: Animator.AnimatorListener {
    override fun onAnimationRepeat(animation: Animator?) {
    }

    @JvmDefault
    override fun onAnimationEnd(animation: Animator?, isReverse: Boolean) {
        super.onAnimationEnd(animation, isReverse)
    }

    override fun onAnimationEnd(animation: Animator?) {
    }

    override fun onAnimationCancel(animation: Animator?) {
    }

    @JvmDefault
    override fun onAnimationStart(animation: Animator?, isReverse: Boolean) {
        super.onAnimationStart(animation, isReverse)
    }

    override fun onAnimationStart(animation: Animator?) {
    }
}
