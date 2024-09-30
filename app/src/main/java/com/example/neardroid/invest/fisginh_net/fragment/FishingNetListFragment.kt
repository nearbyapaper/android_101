package com.example.neardroid.invest.fisginh_net.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.neardroid.R
import com.example.neardroid.invest.fisginh_net.adapter.FishingNetBusinessListAdapter
import com.example.neardroid.invest.fisginh_net.viewmodel.FishingNetViewModel
import com.example.neardroid.invest.fisginh_net.viewmodel.FishingNetViewModelFactory
import javax.inject.Inject

class FishingNetListFragment : Fragment() {

    lateinit var businessRecyclerView: RecyclerView
    lateinit var adapter: FishingNetBusinessListAdapter

    @Inject lateinit var viewModel: FishingNetViewModel
    @Inject lateinit var factory: FishingNetViewModelFactory

    override fun onResume() {
        super.onResume()

        getBusinessList()
    }

    private fun getBusinessList() {
        viewModel.getFocusBusinessList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fishing_net_list, container, false)
        binding(view)
        setupViewModel()
        return view
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, factory)[FishingNetViewModel::class.java]
    }

    private fun binding(view: View) {
        businessRecyclerView = view.findViewById(R.id.businessRecyclerView)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        TODO("Not yet implemented")
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FishingNetListFragment().apply {
            }
    }
}