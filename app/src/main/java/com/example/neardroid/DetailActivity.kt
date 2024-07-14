package com.example.neardroid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    // var
    var textNameJedi: TextView? = null
    var etTextLightSaber: EditText? = null
    var etTextForce: EditText? = null
    var okButton: Button? = null

    // end var
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        bindWidget()
        // get intent
        var intent = intent // getIntent()
        textNameJedi?.text = "Master " + intent.getStringExtra("MASTER_JEDI")
    }

    private fun bindWidget() {
        textNameJedi = findViewById(R.id.nameTextView)
        etTextLightSaber = findViewById(R.id.lightSaberEditText)
        etTextForce = findViewById(R.id.forceEditText)
        okButton = findViewById(R.id.okButton)

        handleEvent()
    }

    private fun handleEvent() {
        okButton?.setOnClickListener {
            val intent = Intent(this, ConfirmActivity::class.java)
            // set intent
            intent.putExtra("JEDI_NAME", getIntent().getStringExtra("MASTER_JEDI"))
            intent.putExtra("JEDI_SABER", etTextLightSaber?.text.toString())
            intent.putExtra("JEDI_FORCE", etTextForce?.text.toString())
            startActivity(intent)
        }
    }

}