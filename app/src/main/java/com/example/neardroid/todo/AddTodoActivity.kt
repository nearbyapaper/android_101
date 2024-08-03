package com.example.neardroid.todo

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TimePicker
import androidx.core.os.bundleOf
import com.example.neardroid.R
import com.example.neardroid.model.room.Todo
import com.example.neardroid.todo.TodoActivity.Companion.REQUEST_ADD
import com.example.neardroid.util.TimeUtil
import java.util.Calendar

class AddTodoActivity : AppCompatActivity() {
    var titleEditText: EditText? = null
    var timeEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        titleEditText = findViewById(R.id.titleEditText)
        timeEditText = findViewById(R.id.timeEditText)
    }

    // add options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.add_todo_menu, menu)
        return true
    }

    // handler click event options mene
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_todo -> {
                saveTodo()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun saveTodo() {
        // create new instance for bundle result back to parent activity
        val newTodo = Todo(0, titleEditText?.text.toString(), timeEditText?.text.toString(), false)
        var bundle = bundleOf("bundle" to newTodo)
        // set intent content
        val intent = Intent()
        intent.putExtra("newtodo",bundle)
        setResult(REQUEST_ADD,intent)
        // finish for go back to parent Activity
        finish()
    }

    fun openDateDialog(view: View) {
        // get Current Date from Calendar
        val calendar = Calendar.getInstance()
        // set TimePickerDialog Listener
        val timePickerListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            val currTime = TimeUtil().checkTime(hourOfDay, minute)
            timeEditText?.setText(currTime)
        }
        // create TimePickerDialog
        val dialog = TimePickerDialog(
            this,
            timePickerListener,
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )
        // show TimePickerDialog
        dialog.show()
    }


}