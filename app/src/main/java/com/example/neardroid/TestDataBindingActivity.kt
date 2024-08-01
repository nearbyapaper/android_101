package com.example.neardroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.neardroid.databinding.ActivityTestDataBindingBinding
import com.example.neardroid.model.Item

class TestDataBindingActivity : AppCompatActivity() {
    lateinit var binding: ActivityTestDataBindingBinding // from activity_test_data_binding+Binding -> ActivityTestDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test_data_binding)

        val item = Item("snack", 5.00)
        binding.item = item

        val onClickListener = object : TestDataBindingOnClickListener {
            override fun onShuffle() {
                val listItem = listOf(
                    Item("snack", 5.00),
                    Item("coke", 13.00),
                    Item("beer", 53.00)
                )
                val randomList = listItem.shuffled()
                binding.item = randomList[0]
            }
        }

        binding.handler = onClickListener
//        setContentView(R.layout.activity_test_data_binding)
    }


}
