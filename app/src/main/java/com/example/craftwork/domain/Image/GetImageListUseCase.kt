package com.example.craftwork.domain.Image

import androidx.lifecycle.LiveData

class GetImageListUseCase(private val imageListRepository: ImageListRepository) {
    fun getImageList(): LiveData<List<Image>> {
        return imageListRepository.getImageList()
    }
}