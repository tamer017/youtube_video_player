package com.tamer.youtube_video_player

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.annotation.SuppressLint
import android.os.Bundle
import com.tamer.youtube_video_player.R
import android.widget.Toast
import android.content.Intent
import android.view.View
import android.widget.Button
import com.tamer.youtube_video_player.MainActivity

class SearchActivity : AppCompatActivity() {
    var uri: EditText? = null
    var search: Button? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        // setup the xml file
        uri = findViewById<EditText>(R.id.uri)
        search = findViewById<Button>(R.id.search)
        // Add listener to the search button
        search?.setOnClickListener(View.OnClickListener {
            // in case of enter empty uri
            if (uri?.text.toString().isEmpty()) {
                Toast.makeText(this@SearchActivity, "Enter a video id", Toast.LENGTH_LONG).show()
            } else {
                // in case of enter any uri
                val intent = Intent(this@SearchActivity, MainActivity::class.java)
                intent.putExtra("uri", uri?.text.toString())
                startActivity(intent)
            }
        })
    }
}