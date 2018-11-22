package com.manga.mebaad.mangarelease.ui.presenter

import android.view.View
import com.manga.mebaad.mangarelease.MangaApplication
import com.manga.mebaad.mangarelease.base.presenter.BasePresenter
import com.manga.mebaad.mangarelease.data.model.Manga
import com.manga.mebaad.mangarelease.data.model.Tome
import com.manga.mebaad.mangarelease.ui.view.MangaView
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MangaPresenter(val mangaView: MangaView) : BasePresenter() {


    private var tomes: MutableList<Tome> = mutableListOf()
    private val mangaDatabase = MangaApplication.getMangaDatabase()


    fun retrieveManga() {
        initTomes()
        mangaView.displayMangas(tomes)
    }

    private fun initTomes() {

        tomes.add(Tome(1, 1,"description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(2, 1,"description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(3, 1,"description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(4, 1,"description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(5, 1,"description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(6, 1,"description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(11,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(12,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(13,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(14,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(15,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(16,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(21,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(22,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(23,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(24,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(25,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(26,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
    }


    fun createManga(manga : Manga){
        mangaDatabase.MangaDao().insert(manga)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CompletableObserver{
                    override fun onComplete() {
                        mangaView.showError("Complete")
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        mangaView.showError(e.message.toString())
                    }
                })
    }


    fun getAllMangas(){
        mangaDatabase.MangaDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<Manga>>{
                    override fun onSuccess(mangaList: List<Manga>) {
                        if(mangaList != null)
                        {
                            mangaView.showError("onSuccess : " + mangaList.size.toString())
                            mangaView.showError("onSuccess : " + mangaList[0].name)
                            mangaView.showError("onSuccess : " + mangaList[1].name)
                        }
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        mangaView.showError("onError : " + e.message.toString())
                    }
                })
    }

    //region [** BASE METHODS **]
    override fun launchEdit() {
        mangaView.displayEditMode(true, View.VISIBLE)
    }

    override fun cancelEdit() {
        mangaView.displayEditMode(false, View.INVISIBLE)
    }

    override fun confirmEdit() {
        mangaView.displayEditMode(false, View.INVISIBLE)
    }
    //endregion
}