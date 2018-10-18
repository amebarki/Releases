package com.manga.mebaad.mangarelease.data.navigator

import com.manga.mebaad.mangarelease.data.manager.impl.MangaManagerImpl
import com.manga.mebaad.mangarelease.ui.presenter.LibraryPresenter
import com.manga.mebaad.mangarelease.ui.presenter.MangaPresenter
import com.manga.mebaad.mangarelease.ui.presenter.ReleasePresenter
import com.manga.mebaad.mangarelease.ui.view.LibraryView
import com.manga.mebaad.mangarelease.ui.view.MangaView
import com.manga.mebaad.mangarelease.ui.view.ReleaseView


object Navigator {

    private lateinit var mangaManagerImpl: MangaManagerImpl
    private var instance: Navigator? = null

    init {
        instance = this
    }


    fun instance(): Navigator {

        return instance!!
    }


    fun init() {
        mangaManagerImpl = MangaManagerImpl()
    }


    fun initReleasePresenter(view: ReleaseView): ReleasePresenter {
        return ReleasePresenter(view)
    }

    fun initLibraryPresenter(view: LibraryView): LibraryPresenter{
        return LibraryPresenter(view)
    }


    fun initMangaPresenter(view: MangaView): MangaPresenter{
        return MangaPresenter(view)
    }



    fun getMangaManager() : MangaManagerImpl {
        return mangaManagerImpl
    }


}