package com.example.android_videoplayer_example

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android_videoplayer_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.videoView.run {
            setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.movie))
            MediaController(this@MainActivity).apply {
                setAnchorView(this@run)
            }.let {
                setMediaController(it)
            }
            setOnPreparedListener {
                it.isLooping = true
            }
            start()
        }
    }

}