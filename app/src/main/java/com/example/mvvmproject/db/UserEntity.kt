package com.example.mvvmproject.db

import androidx.room.*

@Entity(tableName = "user")
class UserEntity(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "avatar") val avatar: String
)