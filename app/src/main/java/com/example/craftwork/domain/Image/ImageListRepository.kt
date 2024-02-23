package com.example.craftwork.domain.Image

interface ImageListRepository {
    fun deleteImage(image: Image)
    fun editImage(image: Image)
    fun uploadImage(image: Image)
    fun getImage(id: String): Image
    fun getImageList(): List<Image>

}