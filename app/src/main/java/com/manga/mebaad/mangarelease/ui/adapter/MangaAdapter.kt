package com.manga.mebaad.mangarelease.ui.adapter

import android.support.v7.widget.RecyclerView
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.data.model.Manga
import com.manga.mebaad.mangarelease.data.model.Tome
import com.squareup.picasso.Picasso

class MangaAdapter(internal var tomes: List<Tome>, var visibility : Int,var initArray : Boolean, val clickListener: (Int, Int, Boolean) -> Unit) : RecyclerView.Adapter<MangaViewHolder>() {



    companion object {
        internal var itemStateArray: SparseBooleanArray = SparseBooleanArray()
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType: Int): MangaViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_manga, viewGroup, false)
        return MangaViewHolder(view)
    }

    override fun onBindViewHolder(mangaViewHolder: MangaViewHolder, position: Int) {

        if(initArray){
            LibraryAdapter.itemStateArray.clear()
            initArray = false
        }

        val tome= tomes[position]
        mangaViewHolder.bind(tome,position, clickListener)
        mangaViewHolder.tmpCheckBox.isChecked = MangaAdapter.itemStateArray.get(position, false)
        mangaViewHolder.tmpCheckBox.visibility = visibility
    }

    override fun getItemCount(): Int {
        return tomes.size
    }

}


class MangaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleTomeTextView: TextView
    private val coverTomeImageView: ImageView
    val tmpCheckBox: CheckBox = itemView.findViewById(R.id.tome_checkbox) as CheckBox

    init {
        titleTomeTextView = itemView.findViewById(R.id.tome_title_text_view) as TextView
        coverTomeImageView = itemView.findViewById(R.id.tome_cover_image_view) as ImageView
    }

    fun bind(tome: Tome, position: Int, clickListener: (Int, Int, Boolean) -> Unit) {
        titleTomeTextView.text = "TOME " + tome.id
        Picasso.with(coverTomeImageView.context).load(tome.urlCover).fit().into(coverTomeImageView)
        coverTomeImageView.setOnClickListener{clickListener(tome.id, position, tmpCheckBox.isChecked)}
        tmpCheckBox.setOnClickListener {
            if (!MangaAdapter.itemStateArray.get(adapterPosition, false)) {
                tmpCheckBox.isChecked = true
                MangaAdapter.itemStateArray.put(adapterPosition, true)
            } else {
                tmpCheckBox.isChecked = false
                MangaAdapter.itemStateArray.put(adapterPosition, false)
            }
        }
    }
}