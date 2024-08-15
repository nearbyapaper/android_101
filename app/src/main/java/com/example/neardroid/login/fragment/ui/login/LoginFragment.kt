package com.example.neardroid.login.fragment.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.neardroid.MainActivity
import com.example.neardroid.R
import com.example.neardroid.login.activity.ui.login.LoginActivity
import com.example.neardroid.util.AppToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // use AndroidEntryPoint annotation on your LoginFragment to generate the required component
class LoginFragment : Fragment() {

    // val
    private val activity by lazy { requireActivity() as LoginActivity }
//    private val viewModel get() = activity.viewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val usernameEditText = view.findViewById<EditText>(R.id.username)
        val passwordEditText = view.findViewById<EditText>(R.id.password)
        val loginButton = view.findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            AppToast(activity).create(activity,"username : $username / password : $password").show()
            // Handle login logic here
//            viewModel.login(username,password)

            // If login is successful, navigate to the Main Activity or another activity
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    fun createViewModel(){

    }
}