package com.example.neardroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NavStartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NavStartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var setButton: Button? = null
    var historyButton: Button? = null

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setButton = view.findViewById(R.id.setButton)
        historyButton = view.findViewById(R.id.historyButton)

        navController = Navigation.findNavController(view)

        setButton?.setOnClickListener {
            navController.navigate(R.id.action_navStartFragment_to_setFragment)
        }

        historyButton?.setOnClickListener {
            navController.navigate(R.id.action_navStartFragment_to_setHistoryFragment)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NavStartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NavStartFragment().apply {

            }
    }
}