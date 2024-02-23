package com.example.craftwork.domain.Image

class GetImageUseCase(private val imageListRepository: ImageListRepository) {
    fun getImage(id: String): Image {
        return imageListRepository.getImage(id)
    }
}