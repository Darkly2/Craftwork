package com.example.craftwork.domain.Image

class DeleteImageUseCase(private val imageListRepository: ImageListRepository) {

    fun deleteImage(image: Image) {
        imageListRepository.deleteImage(image)
    }
}