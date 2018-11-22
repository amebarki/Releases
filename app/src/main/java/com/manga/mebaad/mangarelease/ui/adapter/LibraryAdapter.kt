package com.manga.mebaad.mangarelease.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.ui.adapter.LibraryAdapter.Companion.itemStateArray

class LibraryAdapter(private var mangaList: List<String>, var visibility : Int, var initArray : Boolean, private val clickListener: (String, Int, Boolean) -> Unit) : androidx.recyclerview.widget.RecyclerView.Adapter<LibraryViewHolder>() {


    companion object {
        internal var itemStateArray: SparseBooleanArray = SparseBooleanArray()
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType: Int): LibraryViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_library, viewGroup, false)
        return LibraryViewHolder(view)
    }

    override fun onBindViewHolder(libraryViewHolder: LibraryViewHolder, position: Int) {
        if(initArray){
            itemStateArray.clear()
            initArray = false
        }


        val mangaTitle = mangaList[position]
        libraryViewHolder.bind(mangaTitle, position, clickListener)
        libraryViewHolder.deleteCheckbox.isChecked = itemStateArray.get(position, true)
        libraryViewHolder.deleteCheckbox.visibility = visibility
    }

    override fun getItemCount(): Int {
        return mangaList.size
    }


}


class LibraryViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView = itemView.findViewById(R.id.library_title_text_view) as TextView
    val deleteCheckbox: CheckBox = itemView.findViewById(R.id.library_delete_checkbox) as CheckBox

    fun bind(mangaTitle: String, position: Int, clickListener: (String, Int, Boolean) -> Unit) {

        titleTextView.text = mangaTitle
        titleTextView.setOnClickListener { clickListener(mangaTitle, position, deleteCheckbox.isChecked) }
        deleteCheckbox.setOnClickListener {
            if (!itemStateArray.get(adapterPosition, true)) {
                deleteCheckbox.isChecked = true
                itemStateArray.put(adapterPosition, true)
            } else {
                deleteCheckbox.isChecked = false
                itemStateArray.put(adapterPosition, false)
            }
        }

    }
}