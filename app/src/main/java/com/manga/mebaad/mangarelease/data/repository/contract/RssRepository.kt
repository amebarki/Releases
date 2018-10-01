package com.manga.mebaad.mangarelease.data.repository.contract

import com.manga.mebaad.mangarelease.api.service.ApiMangaService
import com.manga.mebaad.mangarelease.data.model.Item
import com.manga.mebaad.mangarelease.data.model.RSSObject
import io.reactivex.Single


/**
 * Created by Adam on 24/09/2018.
 */
interface RssRepository {

     fun loadSeinenKurokawa(apiService: ApiMangaService) : Single<List<Item>>

    fun loadShonenKurokawa(apiService: ApiMangaService) : Single<RSSObject>
}