package com.example.neardroid.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neardroid.R
import com.example.neardroid.model.room.Todo
import com.example.neardroid.model.room.TodoDAO
import com.example.neardroid.model.room.TodoDB
import com.example.neardroid.model.room.repositories.TodoRepository
import com.example.neardroid.model.room.viewmodel.TodoViewModel
import com.example.neardroid.model.room.viewmodel.TodoViewModelFactory
import com.example.neardroid.util.OnCheckBoxListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity(),OnCheckBoxListener {
    lateinit  var recyclerView:RecyclerView
    lateinit var viewModel: TodoViewModel
    lateinit var todoAdapter: TodoListAdapter
    var addFAB: FloatingActionButton ?= null

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

        swipHelper()

        // prepare recycleview
        recyclerView.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoListAdapter(this)
        recyclerView.adapter = todoAdapter
        // add action FAB
        addFAB?.setOnClickListener {
            val intent = Intent(this,AddTodoActivity::class.java)
//            startActivity(intent)
            // pass to new activity for want some result from them have to pass request code[REQUEST_ADD]
            startActivityForResult(intent, REQUEST_ADD)
        }

        observeData()
    }

    private fun swipHelper() {
        // this fun create ItemTouchHelper for slide left to delete record

        // create callback for ItemTouchHelper
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.todoList.value?.get(viewHolder.adapterPosition)
                    ?.let { viewModel.delete(it) }
            }
        }

        // create ItemTouchHelper
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        // bind ItemTouchHelper with Recyclerview
        itemTouchHelper.attachToRecyclerView(recyclerView)
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
        addFAB = findViewById(R.id.addFAB)
        Log.d("1995","bindWidget recyclerView :: $recyclerView")
    }

    // for do someting after get result back from child Activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_ADD){
            Log.d("1995","data :: $data")
            val bundle = data?.getBundleExtra("newtodo")
            val todoResult = bundle?.getParcelable<Todo>("bundle")
            Log.d("1995","bundle :: $bundle")
            Log.d("1995","todoResult :: $todoResult")
            if (todoResult != null) {
                viewModel.insert(todoResult)
            }
        }
    }

    companion object{
        val REQUEST_ADD = 1
    }

    override fun onCheck(position: Int, state: Boolean) {
        val targetTodo = viewModel.todoList.value?.get(position)
        Log.d("1995","onCheck targetTodo :: $targetTodo")
        Log.d("1995","onCheck state :: $state")
        if (targetTodo != null) {
            Log.d("1995","update targetTodo ")
            // update in DB when checkbox change
            viewModel.update(Todo(targetTodo.id,targetTodo.title,targetTodo.time,state))
        }
    }
}