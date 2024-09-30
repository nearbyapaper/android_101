package com.example.neardroid.invest.fisginh_net.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.neardroid.R
import com.example.neardroid.invest.fisginh_net.fragment.FishingNetConseptFragment
import com.example.neardroid.invest.fisginh_net.viewmodel.FishingNetViewModel
import com.example.neardroid.invest.fisginh_net.viewmodel.FishingNetViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FishNetActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: FishingNetViewModelFactory
    lateinit var viewModel: FishingNetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish_net)

        initFragment()
        setViewModel()

        supportFragmentManager.addOnBackStackChangedListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.fishingNetContent)
        }
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fishingNetContent, FishingNetConseptFragment.newInstance())
            .commit()
    }

    fun addFragment(fragment: Fragment, stackName: String?) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fishingNetContent, fragment)
            .addToBackStack(stackName)
            .commit()
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fishingNetContent, fragment)
            .commit()
    }

    fun replaceFragment(fragment: Fragment, stackName: String?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fishingNetContent, fragment)
            .addToBackStack(stackName)
            .commit()
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this, factory)[FishingNetViewModel::class.java]
    }
}
