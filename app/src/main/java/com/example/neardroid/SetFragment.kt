package com.example.neardroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.neardroid.model.SetValue

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SetFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
    lateinit var navController: NavController

    private var nameEditText:EditText ?= null
    private var valueEditText:EditText ?= null
    private var button:Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEditText = view.findViewById(R.id.nameEditText)
        valueEditText = view.findViewById(R.id.valueEditText)
        button = view.findViewById(R.id.goButton)
        button?.setOnClickListener {
            handleGo(view)
        }
    }

    private fun handleGo(view : View){
        navController = Navigation.findNavController(view)
        val bundle = bundleOf("setvalue" to SetValue(nameEditText?.text.toString(),valueEditText?.text.toString()))
        navController.navigate(R.id.action_setFragment_to_setHistoryFragment,bundle)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SetFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            SetFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }
}