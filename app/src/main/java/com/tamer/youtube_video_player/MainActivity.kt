package com.tamer.youtube_video_player


import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.os.Bundle
import com.tamer.youtube_video_player.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import android.content.Intent
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import android.widget.Toast
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.tamer.youtube_video_player.SearchActivity

//X9Gqewk8dDw
class MainActivity : AppCompatActivity() {
    var uri_str: String? = ""
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setup the xml file
        val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.youtube_player_view)
        lifecycle.addObserver(youTubePlayerView)
        // get the uei id for the video from the last activity
        val intent = intent
        uri_str = intent.getStringExtra("uri")
        // Add listener to the youtube player
        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = uri_str
                youTubePlayer.loadVideo(videoId!!, 0f)
            }
            // in case of error occurs
            // enter invalid id or example
            override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) {
                super.onError(youTubePlayer, error)
                Toast.makeText(this@MainActivity, "Enter a valid video id", Toast.LENGTH_LONG)
                    .show()
                // back to the previous activity
                val intent1 = Intent(this@MainActivity, SearchActivity::class.java)
                startActivity(intent1)
                finish()
            }
        })
    }
}