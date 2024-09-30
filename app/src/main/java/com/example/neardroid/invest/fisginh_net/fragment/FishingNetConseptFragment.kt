package com.example.neardroid.invest.fisginh_net.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.neardroid.R
import com.example.neardroid.invest.fisginh_net.activity.FishNetActivity

class FishingNetConseptFragment : Fragment() {

    private lateinit var findButton: Button
    private val activity by lazy { requireActivity() as FishNetActivity }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fishing_net_consept, container, false)
        bindWidget(view)
        setActionListener()

        return view
    }

    private fun setActionListener() {
        findButton.setOnClickListener {
            activity.replaceFragment(FishingNetSurveyFragment.newInstance())
        }
    }

    private fun bindWidget(view: View) {
        findButton = view.findViewById(R.id.findButton)
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            FishingNetConseptFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}