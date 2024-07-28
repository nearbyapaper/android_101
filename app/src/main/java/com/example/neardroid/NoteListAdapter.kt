package com.example.neardroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neardroid.model.Note

class NoteListAdapter(private val list: ArrayList<Note>, private val listener: OnNoteClickListener): RecyclerView.Adapter<NoteListViewHoler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteListViewHoler {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return NoteListViewHoler(v)
    }

    override fun onBindViewHolder(holder: NoteListViewHoler, position: Int ) {
//        holder.title?.text = list[position].title
//        holder.detail?.text = list[position].detail
        val current:Note = list[position]
        holder.bind(current,listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class NoteListViewHoler(itemView: View): RecyclerView.ViewHolder(itemView) {
    var title = itemView.findViewById<TextView>(R.id.titleTextView)
    var detail = itemView.findViewById<TextView>(R.id.detailTextView)

    fun bind(note: Note, action: OnNoteClickListener){
        title?.text = note.title
        detail?.text = note.detail

        itemView.setOnClickListener{
            action.onclick(adapterPosition)
        }
    }
}

interface OnNoteClickListener {
    fun onclick(position: Int)
}
