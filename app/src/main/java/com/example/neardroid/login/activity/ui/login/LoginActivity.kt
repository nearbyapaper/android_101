package com.example.neardroid.login.activity.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.neardroid.R
import com.example.neardroid.login.fragment.ui.login.LoginFragment

class LoginActivity : AppCompatActivity() {
    // val
//    @Inject lateinit var factory: LoginViewModelFactory
//    lateinit var viewModel: LoginViewModel
    // end val

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //
//        setupViewModel()

        // Check if the fragment container is empty, then add the fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment())
                .commit()
        }
    }

//    private fun setupViewModel() {
//        viewModel = ViewModelProvider(this, factory)
//            .get(LoginViewModel::class.java)
//    }
}