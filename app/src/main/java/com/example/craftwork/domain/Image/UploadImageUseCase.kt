package com.example.craftwork.domain.Image

class UploadImageUseCase(private val imageListRepository: ImageListRepository) {
    fun uploadImage(image: Image) {
        imageListRepository.uploadImage(image)
    }
}