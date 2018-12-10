package com.manga.mebaad.mangarelease.ui.adapter

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.data.model.Release
import com.manga.mebaad.mangarelease.ui.adapter.ReleaseAdapter.Companion.itemStateArray
import com.squareup.picasso.Picasso


class ReleaseAdapter(internal var releaseList: List<Release>, var initArray : Boolean, val clickListener: (Release,Boolean) -> Unit) : androidx.recyclerview.widget.RecyclerView.Adapter<ReleaseViewHolder>() {

    companion object {
        internal var itemStateArray: SparseBooleanArray = SparseBooleanArray()
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType: Int): ReleaseViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_release, viewGroup, false)
        return ReleaseViewHolder(view)
    }

    override fun onBindViewHolder(releaseViewHolder: ReleaseViewHolder, position: Int) {
        if(initArray){
            ReleaseAdapter.itemStateArray.clear()
            initArray = false
        }

        val release = releaseList[position]
        releaseViewHolder.bind(release,clickListener)
        releaseViewHolder.favoriteCheckBox.isChecked = itemStateArray.get(position, false)
    }

    override fun getItemCount(): Int {
        return releaseList.size
    }

}


    class ReleaseViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    private val summaryTextView: TextView = itemView.findViewById(R.id.release_summary_text_view_card) as TextView
        private val titleTextView: TextView = itemView.findViewById(R.id.release_title_text_view_card) as TextView
        private val categoryTextView: TextView = itemView.findViewById(R.id.release_category_text_view_card) as TextView
        private val coverImageView: ImageView = itemView.findViewById(R.id.release_image_card) as ImageView
        val favoriteCheckBox: CheckBox = itemView.findViewById(R.id.release_favorite_checkbox_card) as CheckBox

        fun bind(release: Release, clickListener: (Release,Boolean) -> Unit) {
        titleTextView.text = release.title
        summaryTextView.text = release.summary
        summaryTextView.movementMethod = ScrollingMovementMethod()
        summaryTextView.isSelected = true
        categoryTextView.text = release.category.toString()
        Picasso.with(coverImageView.context).load(release.urlCover).centerCrop().fit().into(coverImageView)
        favoriteCheckBox.setOnClickListener {
            if (!itemStateArray.get(adapterPosition, false)) {
                favoriteCheckBox.isChecked = true
                itemStateArray.put(adapterPosition, true)
            } else {
                favoriteCheckBox.isChecked = false
                itemStateArray.put(adapterPosition, false)
            }
            clickListener(release,favoriteCheckBox.isChecked) }
    }
}