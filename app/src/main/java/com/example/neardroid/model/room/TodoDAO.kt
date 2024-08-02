package com.example.neardroid.model.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDAO {
    @Update
    fun updateTodo(obj: Todo)

    @Insert
    fun insertTodo(obj: Todo)

    @Delete
    fun deleteTodo(obj: Todo)

    @Query ("SELECT * FROM todo_table")
    fun queryTodo(): LiveData<List<Todo>>
}