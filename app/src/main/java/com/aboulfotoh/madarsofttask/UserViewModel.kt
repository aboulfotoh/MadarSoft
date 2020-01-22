package com.aboulfotoh.madarsofttask

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aboulfotoh.madarsofttask.data.MadarSoftDatabase
import com.aboulfotoh.madarsofttask.data.UserRepository
import com.aboulfotoh.madarsofttask.data.model.User
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {

    private val repository: UserRepository
    val allUsers: LiveData<List<User>>

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val userDao = MadarSoftDatabase.getDatabase(application,viewModelScope).userDao()
        repository = UserRepository(userDao)
        allUsers = repository.allUsers
    }

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }
}