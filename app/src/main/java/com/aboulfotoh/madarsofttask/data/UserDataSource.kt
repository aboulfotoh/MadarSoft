package com.aboulfotoh.madarsofttask.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aboulfotoh.madarsofttask.data.model.User

@Dao
interface UserDataSource {

    @Query("SELECT * from users_table")
    fun getUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg user: User)
}