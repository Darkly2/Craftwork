package com.example.craftwork.domain.Image

class EditImageUseCase(private val imageListRepository: ImageListRepository) {
    fun editImage(image: Image) {
        imageListRepository.editImage(image)
    }
}