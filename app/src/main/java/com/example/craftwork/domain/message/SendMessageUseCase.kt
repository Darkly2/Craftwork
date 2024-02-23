package com.example.craftwork.domain.message

class SendMessageUseCase (private val messageListRepository: MessageListRepository){
    fun sendMessage(message: Message) {
        messageListRepository.sendMessage(message)
    }
}