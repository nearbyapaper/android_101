package com.example.neardroid.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Todo::class], version = 1)
abstract class TodoDB : RoomDatabase() {
    abstract fun todoDao(): TodoDAO // create dao for access db

    companion object { // unique object [Singleton]
        @Volatile // for all thread can access this object
        private var instance: TodoDB? = null
        fun getInstance(context: Context): TodoDB {
            synchronized(this) { // for 1 thread can access this db at the same time
                var newInstance = instance
                if (newInstance == null) { // check singleton
                    newInstance = Room.databaseBuilder(
                        context.applicationContext,
                        TodoDB::class.java,
                        "todo_db"
                    ).addCallback(object : Callback() { // addCallback for initial data in db
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            CoroutineScope(Dispatchers.IO).launch {
                                // CoroutineScope is asycn code have to use Disoatcher
                                // dispatcher -> select work that match for each thread (Main,Default,IO)
                                // Main = UI
                                // Default = CPU (Calculate)
                                // IO = API / Database
                                getInstance(context).todoDao()
                                    .insertTodo(Todo(0, "Initial Value", "12 : 00", false))
                            }
                        }
                    }).build()
                }
                return newInstance // return db
            }
        }
    }
}