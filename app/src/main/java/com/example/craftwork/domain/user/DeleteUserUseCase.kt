package com.example.craftwork.domain.user

class DeleteUserUseCase(private val userRepository: UserRepository) {
    fun deleteUser(user: User) {
        userRepository.deleteUser(user)
    }
}