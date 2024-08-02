package com.example.neardroid.model.room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neardroid.model.room.Todo
import com.example.neardroid.model.room.repositories.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {
    val todoList = repository.todoList

    fun insert(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){ // declare viewModelScope for make Coroutine process with ViewModel [IO thread-> API,DB]
            repository.insert(todo)
        }
    }

    fun update(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){
            repository.update(todo)
        }
    }

    fun delete(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){
            repository.delete(todo)
        }
    }
}