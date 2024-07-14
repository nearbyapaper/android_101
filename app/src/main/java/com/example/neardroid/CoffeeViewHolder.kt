package com.example.neardroid

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CoffeeViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    var bindTitleTextView:TextView?= itemView.findViewById(R.id.titleTextView)
    var bindcontentTextView:TextView?= itemView.findViewById(R.id.contentTextView)
    var bindImageView:ImageView?= itemView.findViewById(R.id.imageView)
    var bindCardView:CardView?= itemView.findViewById(R.id.mainCardView)
}
