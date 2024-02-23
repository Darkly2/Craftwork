package com.example.craftwork.domain.message

import androidx.lifecycle.LiveData
import com.example.craftwork.domain.user.User

class GetMessageListUseCase(private val messageListRepository: MessageListRepository) {
    fun getMessageList(user: User): LiveData<List<Message>> {
        return messageListRepository.getMessageList(user)
    }
}