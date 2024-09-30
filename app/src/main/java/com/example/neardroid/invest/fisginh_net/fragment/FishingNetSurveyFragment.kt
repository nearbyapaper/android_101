package com.example.neardroid.invest.fisginh_net.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.neardroid.R
import com.example.neardroid.invest.fisginh_net.activity.FishNetActivity
import com.example.neardroid.invest.fisginh_net.model.FishingNetBusiness

class FishingNetSurveyFragment : Fragment() {

    private lateinit var saveButton: Button
    private lateinit var nameEditText : EditText
    private lateinit var questionEditText : EditText
    private lateinit var questionEditText2 : EditText
    private lateinit var questionEditText3 : EditText
    private lateinit var questionEditText4 : EditText
    private lateinit var questionEditText5 : EditText

    private fun getFishingActivity(): FishNetActivity = activity as FishNetActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fishing_net_survey, container, false)
        binding(view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setActionListener()
        setObserver()
    }

    private fun setObserver() {
        getFishingActivity().viewModel.saveBusinessResp.observe(viewLifecycleOwner) {
            getFishingActivity().replaceFragment(
                FishingNetListFragment.newInstance()
            )
        }
    }

    private fun setActionListener() {
        saveButton.setOnClickListener {
            val req = FishingNetBusiness(
                name = nameEditText.text.toString(),
                value = questionEditText.text.toString(),
                otherHaveThisValue = questionEditText2.text.toString(),
                wantToAcceptThisValue = questionEditText3.text.toString(),
                whyYouWantToAcceptThisValue = questionEditText4.text.toString(),
                durableValue = questionEditText5.text.toString(),
            )

            getFishingActivity().viewModel.saveBusiness(req)
        }
    }

    private fun binding(view: View) {
        saveButton = view.findViewById(R.id.saveButton)
        nameEditText = view.findViewById(R.id.nameEditText)
        questionEditText = view.findViewById(R.id.questionEditText)
        questionEditText2 = view.findViewById(R.id.questionEditText2)
        questionEditText3 = view.findViewById(R.id.questionEditText3)
        questionEditText4 = view.findViewById(R.id.questionEditText4)
        questionEditText5 = view.findViewById(R.id.questionEditText5)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FishingNetSurveyFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}