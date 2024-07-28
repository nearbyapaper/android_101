package com.example.neardroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neardroid.model.Note

class NoteActivity : AppCompatActivity(),OnNoteClickListener {
    var list = ArrayList<Note>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        for (i in 1..3) {
            list.add(
                Note(
                    "title$i",
                    "detail$i"
                )
            )
        }

        val rcView = findViewById<RecyclerView>(R.id.noteListRCView)
        val adapter = NoteListAdapter(list,this)
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = adapter
    }

    override fun onclick(position: Int) {
//        AppToast().createToast(this,"show note $position").show()
        val intent = Intent(this,NoteDetailActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable("note",list[position])
        intent.putExtras(bundle)
        startActivity(intent)
    }


}
