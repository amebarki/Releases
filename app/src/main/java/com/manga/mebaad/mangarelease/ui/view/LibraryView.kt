package com.manga.mebaad.mangarelease.ui.view

import com.manga.mebaad.mangarelease.base.view.BaseView

interface LibraryView : BaseView {

    fun DisplayMangas(mangas : List<String>)
    fun DisplayEditMode(itemState : Boolean, editState : Int)

}