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
        tomes.add(Tome(2, 1,"description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425367.jpg?itok=gcAE_OT0"))
        tomes.add(Tome(3, 1,"description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351426012.jpg?itok=Ty8ey9QP"))
        tomes.add(Tome(4, 1,"description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782368522097.jpg?itok=ohC6dQqR"))
        tomes.add(Tome(11,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(12,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425367.jpg?itok=gcAE_OT0"))
        tomes.add(Tome(13,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351426012.jpg?itok=Ty8ey9QP"))
        tomes.add(Tome(14,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782368522097.jpg?itok=ohC6dQqR"))
        tomes.add(Tome(15,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(16,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425367.jpg?itok=gcAE_OT0"))
        tomes.add(Tome(21,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351426012.jpg?itok=Ty8ey9QP"))
        tomes.add(Tome(22,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782368522097.jpg?itok=ohC6dQqR"))
        tomes.add(Tome(23,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(24,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425367.jpg?itok=gcAE_OT0"))
        tomes.add(Tome(25,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351426012.jpg?itok=Ty8ey9QP"))
        tomes.add(Tome(26,1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782368522097.jpg?itok=ohC6dQqR"))
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