package com.example.craftwork.domain.user

import androidx.lifecycle.LiveData

class GetFriendListUseCase(private val userListRepository: UserListRepository) {
    fun getFriendList(user: User): LiveData<List<User>> {
        return userListRepository.getFriendList(user)
    }
}