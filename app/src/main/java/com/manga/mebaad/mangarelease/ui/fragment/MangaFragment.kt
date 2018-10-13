package com.manga.mebaad.mangarelease.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manga.mebaad.mangarelease.R
import kotlinx.android.synthetic.main.activity_home.*


class MangaFragment :  BaseFragment() {


    override fun overwriteToolbar() {
        activity!!.activity_toolbar.title = "Manga"

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manga, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

}
