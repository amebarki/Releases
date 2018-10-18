package com.manga.mebaad.mangarelease.data.repository.impl

import com.manga.mebaad.mangarelease.api.service.ApiMangaService
import com.manga.mebaad.mangarelease.data.model.Item
import com.manga.mebaad.mangarelease.data.repository.contract.RssRepository
import com.manga.mebaad.mangarelease.data.model.RSSObject
import io.reactivex.Single

/**
 * Created by Adam on 24/09/2018.
 */
object RssRepositoryImpl : RssRepository {


    override fun loadSeinenKurokawa(apiService: ApiMangaService): Single<List<Item>> {
        val rssObject : Single<RSSObject> = apiService.loadSeinenKurokawa()
        return rssObject.map { it.items }
    }


    override fun loadShonenKurokawa(apiService: ApiMangaService): Single<List<Item>> {
        val rssObject : Single<RSSObject> = apiService.loadShonenKurokawa()
        return rssObject.map { it.items }
    }


}