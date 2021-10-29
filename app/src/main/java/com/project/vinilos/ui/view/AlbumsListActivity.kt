package com.project.vinilos.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.vinilos.data.model.Album
import com.project.vinilos.databinding.ActivityAlbumsListBinding
import com.project.vinilos.ui.viewmodel.AlbumViewModel

class AlbumsListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAlbumsListBinding
    private val albumViewModel: AlbumViewModel by viewModels()

    private lateinit var adapter:AlbumsAdapter
    private val albumsList = mutableListOf<Album>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumsListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        albumViewModel.onCreate()

        albumViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })
    }

    private fun initRecyclerView(){
        adapter = AlbumsAdapter(albumsList)
        binding.rvAlbums.layoutManager = LinearLayoutManager(this)
        binding.rvAlbums.adapter = adapter
    }
}