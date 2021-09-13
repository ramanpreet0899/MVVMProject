package com.example.mvvmproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.*
import com.example.mvvmproject.viewModel.*
import dagger.hilt.android.*
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
    }

    private fun initViewModel() {
        val userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        userViewModel.userList.observe(this, Observer {
            val adapter = UserAdapter(it)
            recycler_view_users.adapter = adapter
        })
    }
}