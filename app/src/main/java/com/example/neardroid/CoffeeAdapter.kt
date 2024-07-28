package com.example.neardroid

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.neardroid.model.Coffee
import com.squareup.picasso.Picasso

class CoffeeAdapter(private val postLise: List<Coffee>, private val context: Context) :
    RecyclerView.Adapter<CoffeeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        return CoffeeViewHolder(
            LayoutInflater.from(context).inflate(R.layout.coffee_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bindTitleTextView?.text = postLise[position].title
//        holder.bindImageView?.setImageDrawable(postLise[position].)
        holder.bindcontentTextView?.text = postLise[position].content
        Picasso.get().load(postLise[position].thumbnail).error(R.mipmap.ic_launcher)
            .placeholder(R.mipmap.ic_launcher_round).into(holder.bindImageView)
        holder.bindCardView?.setOnClickListener {
            // In Adapter Context is this view content = this on Activity / Fragment
            val intent = Intent(context, CoffeeDetailActivity::class.java)
            intent.putExtra("COFFEE_TITLE", holder.bindTitleTextView?.text?.toString())
            intent.putExtra("COFFEE_CONTENT", holder.bindcontentTextView?.text?.toString())
            intent.putExtra("COFFEE_IMAGE", postLise[position].thumbnail)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return postLise.size
    }
}