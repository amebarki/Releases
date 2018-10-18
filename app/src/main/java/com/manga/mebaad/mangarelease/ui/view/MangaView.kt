package com.manga.mebaad.mangarelease.ui.view

import com.manga.mebaad.mangarelease.base.view.BaseView
import com.manga.mebaad.mangarelease.data.model.Tome

interface MangaView : BaseView {
    fun displayMangas(mangas : List<Tome>)
}