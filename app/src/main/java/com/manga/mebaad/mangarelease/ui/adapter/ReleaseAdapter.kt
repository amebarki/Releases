package com.manga.mebaad.mangarelease.ui.adapter

import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.data.model.Release
import com.squareup.picasso.Picasso


class ReleaseAdapter(internal var list: List<Release>) : RecyclerView.Adapter<ReleaseViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType: Int): ReleaseViewHolder{
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_release, viewGroup, false)
        return ReleaseViewHolder(view)
    }

    override fun onBindViewHolder(myViewHolder: ReleaseViewHolder, position: Int) {
        val myObject = list[position]
        myViewHolder.bind(myObject)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}


class ReleaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val summaryTextView: TextView
    private val coverImageView: ImageView

    init {

        summaryTextView = itemView.findViewById(R.id.release_text_view_card) as TextView
        coverImageView = itemView.findViewById(R.id.release_image_card) as ImageView
    }

    fun bind(release: Release) {
        summaryTextView.text = release.title
        Picasso.with(coverImageView.context).load(release.urlCover).centerCrop().fit().into(coverImageView)
    }
}