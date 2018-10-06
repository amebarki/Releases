package com.manga.mebaad.mangarelease.data.manager.impl

import android.util.Log
import com.manga.mebaad.mangarelease.data.manager.contract.MangaManager
import com.manga.mebaad.mangarelease.data.model.Category
import com.manga.mebaad.mangarelease.data.model.Item
import com.manga.mebaad.mangarelease.data.model.Manga
import com.manga.mebaad.mangarelease.data.model.Release

class MangaManagerImpl : MangaManager {


    var mangas : List<Manga>
    get() = mangas
    set(value) {mangas = value}


    override fun createListRelease(items: List<Item>, category: Category): List<Release> {

        var releases: MutableList<Release> = mutableListOf()

            for (item in items) {
                releases.add(Release(item.title,retrieveUrlCover(item.description),retrieveSummary(item.description),category))
            }
        return releases
    }

    override fun retrieveUrlCover(description: String): String {
        val regex = """(?<=src=")(.*)(?="\s)""".toRegex()
        val matchResult = regex.find(description)
        if(matchResult!=null)
            return matchResult.value
        else
            return ""
    }

    override fun retrieveSummary(description: String): String {
        val regex = """(?<=<p>)(.*)(?=<\/p>)""".toRegex()
        val matchResult = regex.find(description)
        if(matchResult!=null)
            return matchResult.value
        else
            return ""
    }

    override fun addManga(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    fun splitTitle(title: String) {
        val regex = """(tome)\s[0-9]*""".toRegex()
        val matchResult = regex.find(title)
        Log.d("RSS : ", title)
        if(matchResult != null)
            Log.d("RSS : ", matchResult.value)
    }


}