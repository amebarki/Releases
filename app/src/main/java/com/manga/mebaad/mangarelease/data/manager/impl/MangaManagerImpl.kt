package com.manga.mebaad.mangarelease.data.manager.impl

import android.util.Log
import com.manga.mebaad.mangarelease.data.manager.contract.MangaManager
import com.manga.mebaad.mangarelease.data.model.Category
import com.manga.mebaad.mangarelease.data.model.Item
import com.manga.mebaad.mangarelease.data.model.Release

class MangaManagerImpl : MangaManager {



    override fun createListRelease(items: List<Item>, category: Category): List<Release> {

        val releases: MutableList<Release> = mutableListOf()

            for (item in items) {
                releases.add(Release(item.title,retrieveUrlCover(item.description),retrieveSummary(item.description),category))
            }
        return releases
    }

    override fun retrieveUrlCover(description: String): String {
        val regex = """(?<=src=")(.*)(?="\s)""".toRegex()
        val matchResult = regex.find(description)
        return if(matchResult!=null)
            matchResult.value
        else
            ""
    }

    override fun retrieveSummary(description: String): String {
        val regex = """(?<=<p>)(.*)(?=</p>)""".toRegex()
        val matchResult = regex.find(description)
        if(matchResult!=null)
            return matchResult.value
        else
            return ""
    }

    override fun addManga(title: String) {
    }


    fun splitTitle(title: String) {
        val regex = """(tome)\s[0-9]*""".toRegex()
        val matchResult = regex.find(title)
        Log.d("RSS : ", title)
        if(matchResult != null) {
            Log.d("RSS : ", matchResult.value)
        }
    }


}