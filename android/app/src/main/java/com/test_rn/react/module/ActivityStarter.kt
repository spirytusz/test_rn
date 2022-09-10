package com.test_rn.react.module

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.test_rn.activity.SecondActivity


class ActivityStarter(context: ReactApplicationContext) : ReactContextBaseJavaModule(context) {
    override fun getName(): String {
        return "ActivityStarter"
    }

    private val handler by lazy { Handler(Looper.getMainLooper()) }

    @ReactMethod
    fun navigateToSecondActivity() {
        handler.post {
            val context = currentActivity
            Log.d(name, "navigateToSecondActivity: currentActivity=$currentActivity")
            context?.startActivity(Intent(context, SecondActivity::class.java))
        }
    }
}