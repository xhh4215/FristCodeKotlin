package com.example.thefristcode.jetpackproject.medias

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thefristcode.jetpackproject.R
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)
        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        viewVideo.setVideoURI(uri)
        playVideo.setOnClickListener {
            if (!viewVideo.isPlaying) {
                viewVideo.start()
            }
        }

        playVideoPause.setOnClickListener {
            if (viewVideo.isPlaying) {
                viewVideo.pause()
            }
        }


        playVideoStop.setOnClickListener {
            if (viewVideo.isPlaying) {
                viewVideo.resume()
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        viewVideo.suspend()
    }
}