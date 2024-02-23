package com.example.craftwork.domain.message

import androidx.lifecycle.LiveData
import com.example.craftwork.domain.user.User

interface MessageListRepository {
    fun deleteMessage(message: Message)
    fun sendMessage(message: Message)
    fun getMessageList(user: User): LiveData<List<Message>>
}