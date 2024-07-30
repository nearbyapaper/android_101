package com.example.neardroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

class CoffeeDetailActivity : AppCompatActivity() {
    // var

    // end var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffee_detail)

        supportFragmentManager.beginTransaction().apply { // beginTransaction for manager operation with fragment
            add(R.id.fragment_layout,OneFragment())
            commit() // start transaction
        }
    }

    fun replaceView(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, fragment)
            .addToBackStack(null)
            .commit()
    }
}