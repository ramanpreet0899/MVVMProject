package com.example.mvvmproject.viewModel

import androidx.lifecycle.*
import com.example.mvvmproject.db.*
import dagger.hilt.android.lifecycle.*
import kotlinx.coroutines.*
import javax.inject.*

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel(){

    val userList = userRepository.getUsers().also {
        refreshUserList()
    }

    private fun refreshUserList() = viewModelScope.launch {
        userRepository.refreshUsers()
    }
}

