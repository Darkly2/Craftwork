package com.example.craftwork.domain.user

class RemoveUserFromFriendListUseCase(private val userListRepository: UserListRepository) {
    fun removeUserFromFriendList(user: User) {
        userListRepository.removeUserFromFriendList(user)
    }
}