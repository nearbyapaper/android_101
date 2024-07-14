package com.example.neardroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class JediMasterListView : AppCompatActivity() {
    // var
    val jediMasterList = arrayOf(
        "Yoda",
        "Obiwan Kenobi",
        "Luke Skywalker",
        "Qui-Gom Jinn",
        "Mace Windu"
    )

    var rcView: RecyclerView? = null
    //end var

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jedi_master_list_view)

        bindRCView()
    }

    private fun bindRCView() {
        rcView = findViewById(R.id.rcView)
        rcView?.layoutManager = LinearLayoutManager(this)
        val itemAdapter = JediMasterListAdapter(jediMasterList, this)
        rcView?.adapter = itemAdapter
    }
}