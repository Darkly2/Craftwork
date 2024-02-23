package com.example.craftwork.domain.user

class AddUserInFriendListUseCase(private val userListRepository: UserListRepository) {
    fun addUserInFriendList(user: User) {
        userListRepository.addUserInFriendList(user)
    }
}