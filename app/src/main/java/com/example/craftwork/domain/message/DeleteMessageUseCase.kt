package com.example.craftwork.domain.message

import com.example.craftwork.domain.Image.ImageListRepository

class DeleteMessageUseCase(private val messageListRepository: MessageListRepository) {
    fun deleteMessage(message: Message) {
        messageListRepository.deleteMessage(message)
    }
}