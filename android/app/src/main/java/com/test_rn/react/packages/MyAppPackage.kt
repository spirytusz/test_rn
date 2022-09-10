package com.test_rn.react.packages

import android.view.View
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ReactShadowNode
import com.facebook.react.uimanager.ViewManager
import com.test_rn.customview.CustomViewManager
import com.test_rn.react.module.ActivityStarter

class MyAppPackage : ReactPackage {
    override fun createNativeModules(context: ReactApplicationContext): MutableList<NativeModule> {
        return mutableListOf(ActivityStarter(context))
    }

    override fun createViewManagers(
        context: ReactApplicationContext
    ): MutableList<ViewManager<out View, out ReactShadowNode<*>>> {
        return mutableListOf(CustomViewManager())
    }
}