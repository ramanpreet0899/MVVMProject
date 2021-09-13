package com.example.mvvmproject.db

import android.util.*
import androidx.lifecycle.*
import com.example.mvvmproject.model.*
import com.example.mvvmproject.service.*
import kotlinx.coroutines.*
import retrofit2.*
import java.util.*
import javax.inject.*

class UserRepository @Inject constructor(private val service: UserService,
                                         private val userDao: UserDao
) {

    fun getUsers(): LiveData<List<UserEntity>> = userDao.getUsers()

    suspend fun refreshUsers() = withContext(Dispatchers.IO) {

        service.getUsers().enqueue(object : Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val users = LinkedList<UserEntity>()
                response.body()?.forEach {
                    users.add(UserEntity(it.id,it.name,it.email,it.avatar))
                }
                userDao.insertUsers(users)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
               Log.e("failure", t.localizedMessage!!.toString())
            }

        })
    }
}