package com.manga.mebaad.mangarelease.domain.RssUseCase

import com.manga.mebaad.mangarelease.api.service.ApiMangaService
import com.manga.mebaad.mangarelease.base.usecase.SingleUseCase
import com.manga.mebaad.mangarelease.data.manager.contract.MangaManager
import com.manga.mebaad.mangarelease.data.model.Category
import com.manga.mebaad.mangarelease.data.model.Release
import com.manga.mebaad.mangarelease.data.navigator.Navigator
import com.manga.mebaad.mangarelease.data.repository.contract.RssRepository
import com.manga.mebaad.mangarelease.data.repository.impl.RssRepositoryImpl
import io.reactivex.Single

/**
 * Created by Adam on 24/09/2018.
 */
class LoadSeinenKurokawaUseCase(private val apiService: ApiMangaService) : SingleUseCase<List<Release>> {

    private val mangaManager: MangaManager = Navigator.instance().getMangaManager()


    override fun execute(): Single<List<Release>> = (RssRepositoryImpl as RssRepository).loadSeinenKurokawa(apiService).map {
        return@map mangaManager.createListRelease(it, Category.SEINEN)
    }

}