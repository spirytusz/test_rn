package com.test_rn.customview

import com.facebook.react.uimanager.BaseViewManager
import com.facebook.react.uimanager.ThemedReactContext


class CustomViewManager : BaseViewManager<CustomView, CustomViewShadowNode>() {

    companion object {
        private const val NAME = "NativeCustomView"
    }

    override fun getName(): String {
        return NAME
    }

    override fun createShadowNodeInstance(): CustomViewShadowNode {
        return CustomViewShadowNode()
    }

    override fun getShadowNodeClass(): Class<out CustomViewShadowNode> {
        return CustomViewShadowNode::class.java
    }

    override fun createViewInstance(context: ThemedReactContext): CustomView {
        return CustomView(context)
    }

    override fun updateExtraData(view: CustomView, extra: Any?) {
        // ignore
    }
}