package com.example.neardroid.login.fragment.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.neardroid.MainActivity
import com.example.neardroid.R
import com.example.neardroid.invest.fisginh_net.activity.FishNetActivity
import com.example.neardroid.login.activity.ui.login.LoginActivity
import com.example.neardroid.login.viewmodel.LoginViewModel
import com.example.neardroid.login.viewmodel.LoginViewModelFactory
import com.example.neardroid.util.AppToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {
    @Inject lateinit var loginViewModel: LoginViewModel
    @Inject lateinit var loginFactory: LoginViewModelFactory

    private val activity by lazy { requireActivity() as LoginActivity }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        loginViewModel = ViewModelProvider(this, loginFactory)[LoginViewModel::class.java]
//        loginViewModel.cl
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setUpViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
    }

    private fun setObserver() {
        loginViewModel.testState.observe(viewLifecycleOwner, Observer {
            if(it.data != null){
                it.data.message?.let { it1 -> AppToast(activity).create(activity, it1).show() }
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val usernameEditText = view.findViewById<EditText>(R.id.username)
        val passwordEditText = view.findViewById<EditText>(R.id.password)
        val loginButton = view.findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener {
//            val username = usernameEditText.text.toString()
//            val password = passwordEditText.text.toString()
//
//            AppToast(activity).create(activity,"username : $username / password : $password").show()
//
//            val intent = Intent(activity, MainActivity::class.java)
//            startActivity(intent)

//            loginViewModel.callTestAPI()

            val intent = Intent(activity, FishNetActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}