package com.example.craftwork.domain.user

class SignUpUserUseCase(private val userRepository: UserRepository) {
    fun signUpUser(
        email: String,
        name: String,
        lastName: String,
        age: Int,
        password: String
    ): User {
        return userRepository.signUpUser(
            email,
            name,
            lastName,
            age,
            password
        )
    }
}