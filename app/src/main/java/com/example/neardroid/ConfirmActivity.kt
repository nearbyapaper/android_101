package com.example.neardroid

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.neardroid.util.AppDialog
import com.example.neardroid.util.OnDialogButtonListener

class ConfirmActivity : AppCompatActivity(),OnDialogButtonListener {
    // var
    var nameTextView: TextView? = null
    var saberTextView: TextView? = null
    var forceTextView: TextView? = null
    var jediButton: Button? = null
    var testAppDialogButton: Button ?= null
    lateinit var dialog: AlertDialog

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

        testAppDialogButton?.setOnClickListener {
            dialog = AppDialog(this).create(this,"Hello Dialog")
            dialog.show()
        }
    }

    private fun bindWidget() {
        nameTextView = findViewById(R.id.nameTextView)
        saberTextView = findViewById(R.id.saberTextView)
        forceTextView = findViewById(R.id.forceTextView)
        jediButton = findViewById(R.id.jediButton)
        testAppDialogButton = findViewById(R.id.testAppDialogButton)
    }

    override fun handlePositiveButton() {
        Log.d("1995","handlePositiveButton")
        dialog.cancel()
    }

    override fun handleNegativeButton() {
        Log.d("1995","handleNegativeButton")
        dialog.cancel()
    }
}