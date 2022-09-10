package com.test_rn.utils

import android.content.Context

object DimenUtils {

    fun sp2px(context: Context = AppUtils.context, spValue: Int): Int {
        val scale = context.resources.displayMetrics.scaledDensity
        return (spValue * scale + 0.5f).toInt()
    }

    fun dp2px(context: Context = AppUtils.context, dpValue: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }
}