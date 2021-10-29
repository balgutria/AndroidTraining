package com.project.vinilos.data.network

import android.util.Log
import android.util.Log.INFO
import com.project.vinilos.core.RetrofitHelper
import com.project.vinilos.data.model.Album
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AlbumService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAlbums():List<Album> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(AlbumApiClient::class.java).getAllAlbums()
            Log.d("RESPONSE", response.body().toString())
            response.body() ?: emptyList()
        }
    }
}