package com.example.neardroid.model.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDAO {
    @Update
    suspend fun updateTodo(obj: Todo)

    @Insert
     suspend fun insertTodo(obj: Todo)

    @Delete
    suspend fun deleteTodo(obj: Todo)

    @Query ("SELECT * FROM todo_table")
    fun queryTodo(): LiveData<List<Todo>>
}