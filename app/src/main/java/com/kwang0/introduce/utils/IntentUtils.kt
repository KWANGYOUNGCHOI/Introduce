package com.kwang0.introduce.utils

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Pair
import android.view.View
import com.kwang0.introduce.R


object IntentUtils {
    fun startExternalBrowser(context: Context, url: String?) {
        url?.also {
            try {
                val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(it))
                context.startActivity(intent)
            } catch (e: Exception) { }
        }
    }

    fun startTransition(activity: Activity?, cls: Class<*>, view: View, transition: String) {
        val intent = Intent(activity, cls)
        view.transitionName = transition
        val pair = Pair<View, String>(view, transition)
        val options = ActivityOptions.makeSceneTransitionAnimation(activity, pair)
        activity?.startActivity(intent, options.toBundle())
    }
}
