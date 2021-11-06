package com.project.vinilos.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.project.vinilos.R
import com.project.vinilos.data.model.Album

class AlbumDetailsActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)
        val album = intent.extras?.get("extra_object") as Album
        val title = findViewById<TextView>(R.id.tvAlbumDetailsTitle)
        title.text = album.name
    }
}