package com.example.craftwork.domain.Image

import androidx.lifecycle.LiveData

interface ImageListRepository {
    fun deleteImage(image: Image)
    fun editImage(image: Image)
    fun uploadImage(image: Image)
    fun getImage(id: String): Image
    fun getImageList(): LiveData<List<Image>>

}