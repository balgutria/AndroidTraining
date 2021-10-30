package com.project.vinilos.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.vinilos.R
import com.project.vinilos.data.model.Album
import kotlinx.android.synthetic.main.item_album.view.*

class AlbumsAdapter(var albums:List<Album>):RecyclerView.Adapter<AlbumsAdapter.AlbumHolder>(){
    class AlbumHolder(val view:View):RecyclerView.ViewHolder(view){
        fun render(album:Album){
            view.tvAlbumTitle.text = album.name
            view.tvAlbumArtist.text = album.artist
            view.tvAlbumYear.text = album.releaseDate
            view.tvAlbumType.text = album.cover
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AlbumHolder(layoutInflater.inflate(R.layout.item_album, parent, false))
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        holder.render(albums[position])
    }

    override fun getItemCount(): Int = albums.size
}