package com.test_rn.customview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.SeekBar
import com.test_rn.databinding.LayoutCustomViewBinding

class CustomView : FrameLayout {

    companion object {
        private const val TAG = "CustomView"
    }

    private val binding by lazy {
        LayoutCustomViewBinding.inflate(LayoutInflater.from(context))
    }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        Log.d(TAG, "constructed")
        init()
    }

    private fun init() {
        addView(binding.root)

        val progressLevelMapping = listOf(
            0 until 20 to ("Hello" to "(Lv1)"),
            20 until 40 to ("Hello My" to "(Lv2)"),
            40 until 60 to ("Hello My Long" to "(Lv3)"),
            60 until 80 to ("Hello My Long Level" to "(Lv4)"),
            80..100 to ("Hello My Long Level Name" to "(Lv5)")
        )
        onProgressChange(0, progressLevelMapping)
        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.d(TAG, "onProgressChanged: progress=$progress")

                onProgressChange(progress, progressLevelMapping)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // ignore
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // ignore
            }
        })
    }

    private fun onProgressChange(
        progress: Int,
        progressLevelMapping: List<Pair<IntRange, Pair<String, String>>>
    ) {
        progressLevelMapping.find { (range, _) ->
            progress in range
        }?.let { (_, levelTexts) ->
            val (levelName, levelNo) = levelTexts
            binding.tvLevelName.text = levelName
            binding.tvLevelNo.text = levelNo
        }
    }

    private fun Int.asMeasureSpecMode() = when (this) {
        ViewGroup.LayoutParams.MATCH_PARENT -> MeasureSpec.EXACTLY
        ViewGroup.LayoutParams.WRAP_CONTENT -> MeasureSpec.AT_MOST
        else -> MeasureSpec.EXACTLY
    }
}