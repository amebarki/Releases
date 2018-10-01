package com.manga.mebaad.mangarelease.domain.UseCase

import com.manga.mebaad.mangarelease.base.usecase.SingleUseCase
import com.manga.mebaad.mangarelease.api.service.ApiMangaService
import com.manga.mebaad.mangarelease.data.model.Item
import com.manga.mebaad.mangarelease.data.repository.contract.RssRepository
import com.manga.mebaad.mangarelease.data.repository.impl.RssRepositoryImpl
import io.reactivex.Single

class LoadShonenKurokawaUseCase(val apiService: ApiMangaService) : SingleUseCase<List<Item>> {


    override fun execute(): Single<List<Item>> = (RssRepositoryImpl as RssRepository).loadShonenKurokawa(apiService).map {
        return@map it.items
    }
}