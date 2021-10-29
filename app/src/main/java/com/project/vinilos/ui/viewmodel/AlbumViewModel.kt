package com.project.vinilos.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.vinilos.data.model.Album
import com.project.vinilos.domain.GetAlbumsUseCase
import com.project.vinilos.domain.GetRandomAlbumUseCase
import kotlinx.coroutines.launch

class AlbumViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val album = MutableLiveData<List<Album>>()

    val getAlbumsUseCase = GetAlbumsUseCase()
    // val getRandomAlbumUseCase = GetRandomAlbumUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAlbumsUseCase()

            if (!result.isNullOrEmpty()){
                album.value = result
                isLoading.postValue(false)
            }
        }
    }
}