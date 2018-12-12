package com.manga.mebaad.mangarelease.ui.presenter

import android.util.Log
import android.view.View
import com.manga.mebaad.mangarelease.MangaApplication
import com.manga.mebaad.mangarelease.base.presenter.BasePresenter
import com.manga.mebaad.mangarelease.data.manager.contract.MangaManager
import com.manga.mebaad.mangarelease.data.model.Manga
import com.manga.mebaad.mangarelease.data.navigator.Navigator
import com.manga.mebaad.mangarelease.ui.view.LibraryView
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LibraryPresenter(val libraryView : LibraryView) : BasePresenter() {


    private var mangaListString: MutableList<String> = mutableListOf()
    private val mangaDatabase = MangaApplication.getMangaDatabase()
    private val mangaManager: MangaManager = Navigator.instance().getMangaManager()



    fun retrieveLibrary(){
        initList()
        mangaDatabase.MangaDao().getAllManga().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<Manga>>{
                    override fun onSuccess(mangaList: List<Manga>) {
                        libraryView.displayMangas(mangaList)
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onError(e: Throwable) {
                    }
                })
    }

    private fun initList() {
        Log.d("LIBRARY", "INIT LIST")
        mangaListString.add("One Piece")
        mangaListString.add("Rudolf Turkey")
        mangaListString.add("Kingdom")
        mangaListString.add("Eyeshield 21")
        mangaListString.add("Arms Peddler")
        mangaListString.add("Saint Seiya - The Lost Canvas - Chronicles")
        mangaListString.add("Platinum End")
        mangaListString.add("Jackals")
        mangaListString.add("Warlords")
        mangaListString.add("Tsubasa Reservoir Chronicles")
        mangaListString.add("Beelzebub")
        mangaListString.add("One Punch Man")
        mangaListString.add("Blood Lad")
        mangaListString.add("Sun Ken Rock")
        mangaListString.add("Origin")
    }


    //region [** BASE METHODS **]
    override fun launchEdit(){
        libraryView.displayEditMode(true,View.VISIBLE)
    }

    override fun cancelEdit(){
        libraryView.displayEditMode(false,View.INVISIBLE)
    }

    override fun confirmEdit(){
        libraryView.displayEditMode(false,View.INVISIBLE)
    }
    //endregion
}