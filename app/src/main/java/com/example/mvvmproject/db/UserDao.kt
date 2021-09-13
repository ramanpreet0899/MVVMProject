package com.example.mvvmproject.db

import androidx.lifecycle.*
import androidx.room.*
import java.util.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUsers(): LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: LinkedList<UserEntity>)
}