package com.kwang0.introduce.utils

import android.content.Context
import android.content.Intent
import android.net.Uri


object IntentUtils {
    fun startExternalBrowser(context: Context, url: String?) {
        url?.also {
            try {
                val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(it))
                context.startActivity(intent)
            } catch (e: Exception) { }
        }
    }
}
