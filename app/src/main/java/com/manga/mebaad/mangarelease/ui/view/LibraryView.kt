package com.manga.mebaad.mangarelease.ui.view

import com.manga.mebaad.mangarelease.base.view.BaseView
import com.manga.mebaad.mangarelease.data.model.Manga

interface LibraryView : BaseView {

    fun displayMangas(mangas : List<Manga>)

}