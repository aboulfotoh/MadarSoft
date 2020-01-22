package com.aboulfotoh.madarsofttask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
class User(
    @PrimaryKey(autoGenerate = true) val userID:Int,
    val userName: String,
    val age: String,
    val jobTitle: String,
    val gender: String
)
