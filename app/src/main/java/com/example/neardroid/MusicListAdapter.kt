package com.example.neardroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neardroid.model.Music

class MusicListAdapter(private val musicList: List<Music>,private val context: Context): RecyclerView.Adapter<MusicListAdapter.MusicViewHolder>() {
    class MusicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var artist: TextView = itemView.findViewById(R.id.artistTextView)
        var title: TextView = itemView.findViewById(R.id.titleSongTextView)
//        var cover = itemView.findViewById<ImageView>(R.id.favCoverImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.music_item,parent,false)
        return  MusicViewHolder(v)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val current = musicList[position]
        bind(current,holder)
    }

    private fun bind(current: Music,holder: MusicViewHolder) {
        holder.artist.text = current.artist
        holder.title.text = current.titleSong
    }

    override fun getItemCount(): Int {
        return musicList.size
    }
}