package com.example.mvvmproject.service

import com.example.mvvmproject.model.*
import com.example.mvvmproject.utils.*
import retrofit2.http.*

interface UserService {
    @GET("users")
    fun getUsers(): Resource<List<User>>
}