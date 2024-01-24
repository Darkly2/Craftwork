package com.example.craftwork.domain.message

data class Message(
    val id: String,
    val text: String,
    val senderId: String,
    val receiverId: String
)
