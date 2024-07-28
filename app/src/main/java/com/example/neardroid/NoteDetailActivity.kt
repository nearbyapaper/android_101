package com.example.neardroid

import android.os.Build.VERSION
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.neardroid.model.Note

class NoteDetailActivity : AppCompatActivity() {
    var headTextView:TextView ?= null
    var contentTextView:TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        onBindWidget()
        val intent = intent
        var note = if(VERSION.SDK_INT > 33){
            intent.getParcelableExtra("note",Note::class.java)
        } else{
            intent.getParcelableExtra("note")
        }

        Log.d("1995","NoteDetailActivity note :: "+note)

        headTextView?.text = note?.title
        contentTextView?.text = note?.detail
    }

    private fun onBindWidget() {
        headTextView = findViewById(R.id.headTextView)
        contentTextView = findViewById(R.id.contentTextView)
    }
}