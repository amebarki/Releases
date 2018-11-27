package com.manga.mebaad.mangarelease.data.manager.impl

import android.util.Log
import com.manga.mebaad.mangarelease.data.manager.contract.MangaManager
import com.manga.mebaad.mangarelease.data.model.*

class MangaManagerImpl : MangaManager {


    override fun createListRelease(items: List<Item>, category: Category): List<Release> {

        val releases: MutableList<Release> = mutableListOf()

        for (item in items) {
            releases.add(Release(item.title, retrieveUrlCover(item.description), retrieveSummary(item.description), category))
        }
        return releases
    }

    override fun retrieveUrlCover(description: String): String {
        val regex = """(?<=src=")(.*)(?="\s)""".toRegex()
        val matchResult = regex.find(description)
        return if (matchResult != null)
            matchResult.value
        else
            ""
    }

    override fun retrieveSummary(description: String): String {
        val regex = """(?<=<p>)(.*)(?=</p>)""".toRegex()
        val matchResult = regex.find(description)
        if (matchResult != null)
            return matchResult.value
        else
            return ""
    }

    fun getMangaTomeNumber(title: String): String {
        val regex = """(tome)\s[0-9]*""".toRegex()
        val regexNum = "[0-9][0-9]".toRegex()
        val matchResult = regex.find(title)

        if (matchResult != null) {
            val numTome = regexNum.find(matchResult.value)
            if (numTome != null) {
                return numTome.value
            } else
                return ""
        } else
            return ""
    }

    fun getMangaName(title: String): String {
        val regex = """\s-\s(tome)\s[0-9]*""".toRegex()
        val matchResult = regex.replace(title, "")
        return if (matchResult != null) {
            matchResult
        } else
            ""
    }


    override fun createManga(release: Release): Manga {
        var manga: Manga = Manga(getMangaName(release.title), release.category, mutableListOf())
        return manga
    }


    override fun findMangaTomes(mangaId: Long, title: String, releaseList: List<Release>): MutableList<Tome> {
        Log.d("findMangaTomes : ", title)
        var tomesList: MutableList<Tome> = mutableListOf()
        var shortlist = releaseList.filter { it.title.contains(title, true) }
        Log.d("findMangaTomes  size : ", shortlist.size.toString())
        for (release in shortlist) {
            var tomeId = getMangaTomeNumber(release.title)
            Log.d("tome Id : ", tomeId)
            tomesList.add(Tome(tomeId.toInt(), mangaId, release.summary, release.urlCover))
        }
        return tomesList
    }

}