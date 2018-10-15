package com.manga.mebaad.mangarelease.ui.presenter

import android.view.View
import com.manga.mebaad.mangarelease.data.model.Tome
import com.manga.mebaad.mangarelease.ui.view.MangaView


class MangaPresenter(val mangaView: MangaView) : BasePresenter() {


    private var tomes: MutableList<Tome> = mutableListOf()

    fun retrieveManga() {
        initTomes()
        mangaView.DisplayMangas(tomes)
    }

    private fun initTomes() {

        tomes.add(Tome(1, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(2, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(3, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(4, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(5, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(6, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(11, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(12, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(13, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(14, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(15, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(16, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(21, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(22, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(23, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(24, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(25, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
        tomes.add(Tome(26, "description", "https://www.kurokawa.fr/sites/kurokawa/files/styles/thumbnail/public/books/9782351425114.jpg?itok=764qj9SZ"))
    }

    //region [** BASE METHODS **]
    override fun launchEdit() {
        mangaView.DisplayEditMode(true, View.VISIBLE)
    }

    override fun cancelEdit() {
        mangaView.DisplayEditMode(false, View.INVISIBLE)
    }

    override fun confirmEdit() {
        mangaView.DisplayEditMode(false, View.INVISIBLE)
    }
    //endregion
}