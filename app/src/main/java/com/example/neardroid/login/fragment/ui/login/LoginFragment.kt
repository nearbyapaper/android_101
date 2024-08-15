package com.example.neardroid.login.fragment.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.neardroid.INetworkAPI
import com.example.neardroid.MainActivity
import com.example.neardroid.R
import com.example.neardroid.di_test.UserPreference
import com.example.neardroid.login.activity.ui.login.LoginActivity
import com.example.neardroid.util.AppToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

//    @Inject lateinit var coffeeAPI: INetworkAPI
    @Inject lateinit var userPreference: UserPreference

    private val activity by lazy { requireActivity() as LoginActivity }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val usernameEditText = view.findViewById<EditText>(R.id.username)
        val passwordEditText = view.findViewById<EditText>(R.id.password)
        val loginButton = view.findViewById<Button>(R.id.login_button)

//        Log.d("1995","coffeeAPI :: $coffeeAPI")
//        Log.d("1995","userPreference :: $userPreference")

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            AppToast(activity).create(activity,"username : $username / password : $password").show()

            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}