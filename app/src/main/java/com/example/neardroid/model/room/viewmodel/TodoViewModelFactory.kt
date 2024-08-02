package com.example.neardroid.model.room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.neardroid.model.room.repositories.TodoRepository

class TodoViewModelFactory(private val repository: TodoRepository): ViewModelProvider.Factory {
    // implement ViewModelProvider.Factory for make TodoViewModelFactory be ViewModelFactor
    // ViewModelFactory use to create instance of ViewModel
    // create for default ViewModel not have params in constructor. but in TodoViewModel have repository in constructor.
    // actually I create TodoViewModelFactory

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TodoViewModel::class.java)){
            return TodoViewModel(repository) as T
        }

        // error when pass params wrong
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}