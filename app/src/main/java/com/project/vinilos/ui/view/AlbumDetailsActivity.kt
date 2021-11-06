package com.project.vinilos.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.project.vinilos.R
import com.project.vinilos.data.model.Album
import com.project.vinilos.databinding.ActivityAlbumDetailsBinding
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class AlbumDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val album = intent.extras?.get("extra_object") as Album
        setSupportActionBar(findViewById(R.id.toolbar))
        Picasso.get().load(album.cover)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(binding.bgAlbumImage)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = findViewById<TextView>(R.id.tvAlbumDetailsTitle)
        title.text = album.name

        val description = findViewById<TextView>(R.id.tvAlbumDetailsDescription)
        description.text = album.description

        val artist = findViewById<TextView>(R.id.tvAlbumDetailsArtist)
        artist.text = album.recordLabel
    }
}