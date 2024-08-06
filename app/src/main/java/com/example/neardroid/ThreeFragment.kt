package com.example.neardroid

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.neardroid.album.ui.TestRetrofitActivity
import com.example.neardroid.todo.TodoActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThreeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThreeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var navButton: Button ?= null
    private var dataBindingButton: Button ?= null
    private var mvvmRoomButton: Button ?= null
    private var mvvmRetrofitButton: Button ?= null
    private var simpleRetrofitButton: Button ?= null
    private val activity by lazy { requireActivity() as CoffeeDetailActivity }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navButton = view.findViewById(R.id.navButton)
        dataBindingButton = view.findViewById(R.id.dataBindingButton)
        mvvmRoomButton = view.findViewById(R.id.mvvmRoomButton)
        mvvmRetrofitButton = view.findViewById(R.id.mvvmRetrofitButton)
        simpleRetrofitButton = view.findViewById(R.id.simpleRetrofitButton)

        navButton?.setOnClickListener {
            val intent = Intent(activity,TestNavGraphActivity::class.java)
            startActivity(intent)
        }

        dataBindingButton?.setOnClickListener {
            val intent = Intent(activity,TestDataBindingActivity::class.java)
            startActivity(intent)
        }

        mvvmRoomButton?.setOnClickListener {
            val intent = Intent(activity, TodoActivity::class.java)
            startActivity(intent)
        }

        simpleRetrofitButton?.setOnClickListener {
            val intent = Intent(activity,TestRetrofitActivity::class.java)
            startActivity(intent)
        }

        mvvmRetrofitButton?.setOnClickListener {
            val intent = Intent(activity,MVVMWithRetrofitActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThreeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            ThreeFragment().apply {
            }
    }
}