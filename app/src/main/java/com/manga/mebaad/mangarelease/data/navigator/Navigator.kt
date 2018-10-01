package com.manga.mebaad.mangarelease.data.navigator

import android.content.Context
import com.manga.mebaad.mangarelease.data.manager.impl.MangaManagerImpl
import com.manga.mebaad.mangarelease.ui.presenter.ReleasePresenter
import com.manga.mebaad.mangarelease.ui.view.ReleaseView


object Navigator {

    private lateinit var mangaManagerImpl: MangaManagerImpl
    private var instance: Navigator? = null

    init {
        instance = this
    }


    fun Instance(): Navigator {

        return instance!!
    }


    fun init() {
        mangaManagerImpl = MangaManagerImpl()
    }


    fun initReleasePresenter(context: Context, view: ReleaseView): ReleasePresenter {
        return ReleasePresenter(context, view)
    }



    fun getMangaManager() : MangaManagerImpl {
        return mangaManagerImpl
    }


}