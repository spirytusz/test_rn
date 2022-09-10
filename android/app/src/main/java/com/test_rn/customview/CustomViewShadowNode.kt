package com.test_rn.customview

import com.facebook.react.uimanager.LayoutShadowNode
import com.facebook.yoga.YogaMeasureFunction
import com.facebook.yoga.YogaMeasureMode
import com.facebook.yoga.YogaMeasureOutput
import com.facebook.yoga.YogaNode
import com.test_rn.utils.DimenUtils

class CustomViewShadowNode : LayoutShadowNode(), YogaMeasureFunction {

    init {
        setMeasureFunction(this)
    }

    private val minHeight by lazy { computeMinHeight() }

    override fun measure(
        node: YogaNode?,
        width: Float,
        widthMode: YogaMeasureMode?,
        height: Float,
        heightMode: YogaMeasureMode?
    ): Long {
        return YogaMeasureOutput.make(width, minHeight)
    }

    private fun computeMinHeight(): Float {
        val dp4 = DimenUtils.dp2px(dpValue = 4)
        val dp16 = dp4 * 4

        val seekbarHeight = DimenUtils.dp2px(dpValue = 56)
        val levelTextHeight = DimenUtils.sp2px(spValue = 24)

        val clLevelHeightWithMargin = levelTextHeight + dp16 /*marginTop*/ + dp16 /*marginBottom*/
        return (seekbarHeight + clLevelHeightWithMargin).toFloat()
    }
}