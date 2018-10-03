package com.manga.mebaad.mangarelease.ui.adapter

import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.data.model.Release
import com.squareup.picasso.Picasso


class ReleaseAdapter(internal var releaseList: List<Release>, val clickListener: (Release,Boolean) -> Unit) : RecyclerView.Adapter<ReleaseViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType: Int): ReleaseViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_release, viewGroup, false)
        return ReleaseViewHolder(view)
    }

    override fun onBindViewHolder(releaseViewHolder: ReleaseViewHolder, position: Int) {
        val release = releaseList[position]
        releaseViewHolder.bind(release,clickListener)
    }

    override fun getItemCount(): Int {
        return releaseList.size
    }

}


    class ReleaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val summaryTextView: TextView
    private val titleTextView: TextView
    private val categoryTextView: TextView
    private val coverImageView: ImageView
    private val favoriteCheckBox: CheckBox

    init {
        titleTextView = itemView.findViewById(R.id.release_title_text_view_card) as TextView
        summaryTextView = itemView.findViewById(R.id.release_summary_text_view_card) as TextView
        categoryTextView = itemView.findViewById(R.id.release_category_text_view_card) as TextView
        coverImageView = itemView.findViewById(R.id.release_image_card) as ImageView
        favoriteCheckBox = itemView.findViewById(R.id.release_favorite_checkbox_card) as CheckBox
    }

    fun bind(release: Release, clickListener: (Release,Boolean) -> Unit) {
        titleTextView.text = release.title
        summaryTextView.text = release.summary
        summaryTextView.movementMethod = ScrollingMovementMethod()
        categoryTextView.text = release.category.toString()
        Picasso.with(coverImageView.context).load(release.urlCover).centerCrop().fit().into(coverImageView)
        favoriteCheckBox.setOnClickListener { clickListener(release,favoriteCheckBox.isChecked) }

    }
}