package com.manga.mebaad.mangarelease.data.manager.contract

import com.manga.mebaad.mangarelease.data.model.*

interface MangaManager {

    fun createListRelease(items : List<Item>,category: Category) : List<Release>

    fun retrieveUrlCover(description : String) : String

    fun retrieveSummary(description: String) : String

    fun createManga(release : Release) : Manga

    fun findMangaTomes(mangaId : Long,title : String, releaseList : List<Release>) : MutableList<Tome>

    fun checkFavoriteRelease(mangaList : List<Manga>,releaseList : List<Release>) : List<Int>

    fun sortReleases(releaseList: List<Release>, option : Int) : MutableList<Release>
}