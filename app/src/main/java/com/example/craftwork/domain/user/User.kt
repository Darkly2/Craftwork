package com.example.craftwork.domain.user

data class User (
    val id: String,
    val email: String,
    val name: String,
    val lastName: String,
    val registrationDate: Long,
    var age: Int,
    var timeWithUs: Int,
    var description: String,
    var password: String
)