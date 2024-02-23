package com.example.craftwork.domain.user

class SignOutUserUseCase(private val userRepository: UserRepository) {
    fun signOutUser() {
        userRepository.signOutUser()
    }
}