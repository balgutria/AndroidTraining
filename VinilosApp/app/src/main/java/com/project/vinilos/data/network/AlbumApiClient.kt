package com.project.vinilos.data.network

import com.project.vinilos.data.model.Album
import retrofit2.Response
import retrofit2.http.GET

interface AlbumApiClient {
    @GET("albums.json")
    suspend fun getAllAlbums():Response<List<Album>>
}