package com.example.neardroid.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neardroid.R
import com.example.neardroid.model.room.TodoDAO
import com.example.neardroid.model.room.TodoDB
import com.example.neardroid.model.room.repositories.TodoRepository
import com.example.neardroid.model.room.viewmodel.TodoViewModel
import com.example.neardroid.model.room.viewmodel.TodoViewModelFactory

class TodoActivity : AppCompatActivity() {
    lateinit  var recyclerView:RecyclerView
    lateinit var viewModel: TodoViewModel
    lateinit var todoAdapter: TodoListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        bindWidget()
        initUI()

    }

    private fun initUI() {
        // prepare MVVM + Room
        val dao = TodoDB.getInstance(this).todoDao()
        Log.d("1995","initUI dao :: $dao")
        val repository = TodoRepository(dao)
        Log.d("1995","initUI repository :: $repository")
        val factory = TodoViewModelFactory(repository)
        Log.d("1995","initUI factory :: $factory")
        viewModel = ViewModelProvider(this,factory).get(TodoViewModel::class.java)
        Log.d("1995","initUI viewModel :: $viewModel")
        
        // prepare recycleview
        recyclerView.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoListAdapter()
        recyclerView.adapter = todoAdapter

        observeData()
    }

    private fun observeData() {
        Log.d("1995","observeData viewModel.todoList :: "+viewModel.todoList)
        viewModel.todoList.observe(this, Observer {
            Log.d("1995","observeData it :: $it")
            if(it != null){
                todoAdapter.submitList(it)
                recyclerView.adapter = todoAdapter
            }
        })
    }

    private fun bindWidget() {
        recyclerView = findViewById(R.id.todoRCView)
        Log.d("1995","bindWidget recyclerView :: $recyclerView")
    }
}