package com.example.craftwork.domain.user

data class User (
    val id: Int,
    val name: String,
    val lastName: String,
    val registrationDate: Long,
    var age: Int,
    var timeWithUs: Int,
    var description: String
)