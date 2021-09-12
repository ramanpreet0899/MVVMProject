package com.example.mvvmproject.service

import retrofit2.*
import retrofit2.converter.gson.*

const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

class UserProvider {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}