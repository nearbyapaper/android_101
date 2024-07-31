package com.example.neardroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.neardroid.model.SetValue

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [SetHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SetHistoryFragment : Fragment() {

    private var nameText: TextView?= null
    private var valueText: TextView?= null
    private var matDesignButton: Button?= null

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        var argsBundle = arguments

        Log.d("1995","argsBundle :: $argsBundle")

        nameText = view.findViewById(R.id.nameTextView)
        valueText = view.findViewById(R.id.valueTextView)
        matDesignButton = view.findViewById(R.id.matDesignButton)
        matDesignButton?.setOnClickListener {
            val intent = Intent(activity,TestMaterialDesignActivity::class.java)
            startActivity(intent)
        }

        if (arguments?.isEmpty == true){
            nameText?.text = "None"
            valueText?.text = "None"
        }else{
            val data = argsBundle?.get("setvalue") as SetValue
            Log.d("1995","data :: $data")
            nameText?.text = data.name.toString()
            valueText?.text = data.value.toString()
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SetHistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            SetHistoryFragment().apply {
            }
    }
}