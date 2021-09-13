package com.example.mvvmproject.service

import com.example.mvvmproject.model.*
import retrofit2.*
import retrofit2.http.*

interface UserService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}