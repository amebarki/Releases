package com.manga.mebaad.mangarelease.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.data.model.Tome

class MangaAdapter(internal var context: Context, internal var tomes: List<Tome>) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val food = this.tomes[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var foodView = inflator.inflate(R.layout.card_view_manga, null)

        return foodView
    }

    override fun getItem(position: Int): Any {
        return tomes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return tomes.size
    }

}