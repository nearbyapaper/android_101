package com.example.neardroid

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class JediMasterListAdapter(private val list: Array<String>, val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {
    // Step for work
    // 1. onCreateViewHolder
    // 2. class ViewHolder
    // 3. onBindViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create view for ViewHolder
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        // return ViewHolder to class ViewHolder
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // holder = row
        // position = index of array
        holder.bindJediNameTextView?.text = list[position]
        holder.binfJediCardView?.setOnClickListener {
            gotoCoffeePage()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun gotoCoffeePage() {
        val intent = Intent(context, CoffeeActivity::class.java)
        context.startActivity(intent)
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val bindJediNameTextView: TextView? = itemView.findViewById(R.id.textView)
    val binfJediCardView: CardView? = itemView.findViewById(R.id.jediCardView)
}