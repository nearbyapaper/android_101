package com.example.neardroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class CoffeeDetailActivity : AppCompatActivity() {
    // var
    var titleTextView: TextView? = null
    var contentTextView: TextView? = null
    var coffeeImageView: ImageView? = null
    var button: Button? = null

    // end var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffee_detail)


        Log.d("1995", "onCreate CoffeeDetailActivity")
        var intent = intent
        bindWidget()
        Log.d("1995", "titleTextView")
        titleTextView?.text = intent.getStringExtra("COFFEE_TITLE")
        Log.d("1995", "contentTextView")
        contentTextView?.text = intent.getStringExtra("COFFEE_CONTENT")
//        coffeeImageView?.setImageResource(intent.getIntExtra("COFFEE_CONTENT",0))
        Log.d("1995", "coffeeImageView")
        Picasso.get().load(intent.getStringExtra("COFFEE_IMAGE")).error(R.mipmap.ic_launcher)
            .placeholder(R.mipmap.ic_launcher_round).into(coffeeImageView)

        button?.setOnClickListener {
            goToNote()
        }
        Log.d("1995", "done !!!")
    }

    private fun goToNote() {
        val intent = Intent(this,NoteActivity::class.java)
        startActivity(intent)
    }

    private fun bindWidget() {
        titleTextView = findViewById(R.id.showTitleTextView)
        contentTextView = findViewById(R.id.contentCoffeTextView)
        coffeeImageView = findViewById(R.id.coffeeImageView)
        button = findViewById(R.id.coffeeButton)
    }
}