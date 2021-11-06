package com.project.vinilos.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.project.vinilos.R
import com.project.vinilos.data.models.Album
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.logout) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}