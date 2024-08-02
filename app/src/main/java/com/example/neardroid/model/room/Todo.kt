package com.example.neardroid.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "todo_table")
data class Todo(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "todo_id")
    val id:Int,
    val title:String,
    val time:String,
    val isComplete:Boolean
)
