package com.manga.mebaad.mangarelease.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.manga.mebaad.mangarelease.R

class LibraryAdapter(internal var mangaList: List<String>, val clickListener: (String,Int) -> Unit) : RecyclerView.Adapter<LibraryViewHolder>() {



    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType: Int): LibraryViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_library, viewGroup, false)
        return LibraryViewHolder(view)
    }

    override fun onBindViewHolder(libraryViewHolder: LibraryViewHolder, position: Int) {
        val mangaTitle = mangaList[position]
        libraryViewHolder.bind(mangaTitle, position,clickListener)
    }

    override fun getItemCount(): Int {
        return mangaList.size
    }


}



class LibraryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView


    init {
        titleTextView = itemView.findViewById(R.id.library_title_text_view) as TextView
    }

    fun bind(mangaTitle: String, position : Int, clickListener: (String, Int) -> Unit) {
        titleTextView.text = mangaTitle
        titleTextView.setOnClickListener { clickListener(mangaTitle,position) }

    }

}