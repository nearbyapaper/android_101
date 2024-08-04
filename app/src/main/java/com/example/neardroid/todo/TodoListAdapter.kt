package com.example.neardroid.todo

import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neardroid.R
import com.example.neardroid.model.room.Todo
import com.example.neardroid.util.OnCheckBoxListener

class TodoListAdapter(private val onCheckBoxListener: OnCheckBoxListener) : RecyclerView.Adapter<TodoListAdapter.TodoListViewHolder>() {
    var todoList = listOf<Todo>()

    inner class TodoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textTitle = itemView.findViewById<TextView>(R.id.titleTextView)
        var timeTitle = itemView.findViewById<TextView>(R.id.timeTextView)
        var checkBox = itemView.findViewById<CheckBox>(R.id.checkBox)

        fun bind(todo: Todo, action: OnCheckBoxListener) {
            textTitle.text = todo.title
            timeTitle.text = todo.time
            checkBox.isChecked = todo.isComplete

            if(checkBox.isChecked){
                textTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }

            checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
                Log.d("1995","setOnCheckedChangeListener isChecked :: $isChecked")
                if(isChecked){
                    action.onCheck(adapterPosition,true)
                }else{
                    action.onCheck(adapterPosition,false)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        Log.d("1995","onCreateViewHolder v :: $v")
        return TodoListViewHolder(v)
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        val current = todoList[position]
        Log.d("1995","onBindViewHolder current :: $current")
        holder.bind(current,onCheckBoxListener)
    }

    override fun getItemCount(): Int = todoList.size

    fun submitList(list: List<Todo>) {
        Log.d("1995","submitList list :: $list")
        this.todoList = list
    }
}