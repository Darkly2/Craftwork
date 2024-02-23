package com.example.craftwork.domain.user

interface UserRepository {
    fun deleteUser(user: User)
    fun signInUser(email: String, password: String)
    fun signUpUser(email: String,
                   name: String,
                   lastName: String,
                   age: Int,
                   password: String): User
    fun signOutUser()
}