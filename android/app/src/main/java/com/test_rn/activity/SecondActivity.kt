package com.test_rn.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.test_rn.databinding.LayoutSecondActivityBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: LayoutSecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutSecondActivityBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }
}