package com.manga.mebaad.mangarelease.api.service

import com.manga.mebaad.mangarelease.data.model.RSSObject
import io.reactivex.Single
import retrofit2.http.GET


interface ApiMangaService {


    @GET("api.json?rss_url=https://www.kurokawa.fr/rss-subscribe/books-seinen/rss.xml")
    fun loadSeinenKurokawa(): Single<RSSObject>

    @GET("api.json?rss_url=https://www.kurokawa.fr/rss-subscribe/books-shonen/rss.xml")
    fun loadShonenKurokawa(): Single<RSSObject>


}

