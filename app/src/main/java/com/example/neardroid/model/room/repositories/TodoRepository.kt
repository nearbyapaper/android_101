package com.example.neardroid.model.room.repositories

import com.example.neardroid.model.room.Todo
import com.example.neardroid.model.room.TodoDAO
import com.example.neardroid.util.AppToast

class TodoRepository(private val dao: TodoDAO) {
    val todoList = dao.queryTodo()

    suspend fun insert(todo: Todo){ // suspend fun = async fun
            dao.insertTodo(todo)
    }

    suspend fun update(todo: Todo){
            dao.updateTodo(todo)
    }

    suspend fun delete(todo: Todo){
            dao.deleteTodo(todo)
    }
}