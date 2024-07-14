package com.example.neardroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    var cardView1: CardView? = null
    var cardView2: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindWidget()
    }

    private fun bindWidget() {
        cardView1 = findViewById(R.id.cardView1)
        cardView2 = findViewById(R.id.cardView2)

        handleEvent()
    }

    private fun handleEvent() {
        cardView1?.setOnClickListener {
            handleNextPage("Yoda")
        }

        cardView2?.setOnClickListener {
            handleNextPage("Luke")
        }
    }

    private fun handleNextPage(name: String) {
        // Intent(currentActivity,destinationActivity)
        val intent = Intent(this, DetailActivity::class.java)
        // putExtra for send data to destination activity
        intent.putExtra("MASTER_JEDI", name)
        // start intent
        startActivity(intent)
    }
}