package com.manga.mebaad.mangarelease.ui.presenter

import android.util.Log
import android.view.View
import com.manga.mebaad.mangarelease.ui.view.LibraryView

class LibraryPresenter(val libraryView : LibraryView) : BasePresenter() {


    private var mangaList: MutableList<String> = mutableListOf()

    fun retrieveLibrary(){
        initList()
        libraryView.DisplayMangas(mangaList)
    }

    private fun initList() {
        Log.d("LIBRARY", "INIT LIST")
        mangaList.add("One Piece")
        mangaList.add("Rudolf Turkey")
        mangaList.add("Kingdom")
        mangaList.add("Eyeshield 21")
        mangaList.add("Arms Peddler")
        mangaList.add("Saint Seiya - The Lost Canvas - Chronicles")
        mangaList.add("Platinum End")
        mangaList.add("Jackals")
        mangaList.add("Warlords")
        mangaList.add("Tsubasa Reservoir Chronicles")
        mangaList.add("Beelzebub")
        mangaList.add("One Punch Man")
        mangaList.add("Blood Lad")
        mangaList.add("Sun Ken Rock")
        mangaList.add("Origin")
    }


    //region [** BASE METHODS **]
    override fun launchEdit(){
        libraryView.DisplayEditMode(true,View.VISIBLE)
    }

    override fun cancelEdit(){
        libraryView.DisplayEditMode(false,View.INVISIBLE)
    }

    override fun confirmEdit(){
        libraryView.DisplayEditMode(false,View.INVISIBLE)
    }
    //endregion
}