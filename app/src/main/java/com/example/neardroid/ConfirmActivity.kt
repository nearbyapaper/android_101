package com.example.neardroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class ConfirmActivity : AppCompatActivity() {
    // var
    var nameTextView: TextView? = null
    var saberTextView: TextView? = null
    var forceTextView: TextView? = null
    var jediButton: Button? = null

    //end var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        bindWidget()
        // get intent
        var intent = intent // getIntent()
        nameTextView?.text = intent.getStringExtra("JEDI_NAME")
        saberTextView?.text = intent.getStringExtra("JEDI_SABER")
        forceTextView?.text = intent.getStringExtra("JEDI_FORCE")
        // set handle ecent
        jediButton?.setOnClickListener {
            val nextIntent = Intent(this, JediMasterListView::class.java)
            startActivity(nextIntent)
        }
    }

    private fun bindWidget() {
        nameTextView = findViewById(R.id.nameTextView)
        saberTextView = findViewById(R.id.saberTextView)
        forceTextView = findViewById(R.id.forceTextView)
        jediButton = findViewById(R.id.jediButton)
    }
}