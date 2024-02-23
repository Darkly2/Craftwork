package com.example.craftwork.domain.user

import androidx.lifecycle.LiveData

interface UserListRepository {
     fun addUserInFriendList(user: User)
     fun getFriendList(user: User): LiveData<List<User>>
     fun removeUserFromFriendList (user: User)
}