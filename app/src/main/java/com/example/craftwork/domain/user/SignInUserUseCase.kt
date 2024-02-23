package com.example.craftwork.domain.user

class SignInUserUseCase (private val userRepository: UserRepository){
    fun signInUser(email: String, password: String) {
        userRepository.signInUser(email, password)
    }
}