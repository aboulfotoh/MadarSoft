package com.aboulfotoh.madarsofttask.data

import androidx.lifecycle.LiveData
import com.aboulfotoh.madarsofttask.data.model.User

class UserRepository(private val userDao: UserDataSource) {
    val allWords: LiveData<List<User>> = userDao.getUsers()

    suspend fun insert(user: User) {
        userDao.insert(user)
    }
}