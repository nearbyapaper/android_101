package com.example.neardroid.invest.fisginh_net.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neardroid.R
import com.example.neardroid.invest.fisginh_net.model.FishingNetBusiness

class FishingNetBusinessListAdapter (
    private val businessList: List<FishingNetBusiness>,
    private val context: Context
): RecyclerView.Adapter<FishingNetBusinessListAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = View.inflate(context, R.layout.card_business, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = businessList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTextView.text = businessList[position].name
    }
}