package com.manga.mebaad.mangarelease.data.manager.impl

import android.util.Log
import com.manga.mebaad.mangarelease.data.manager.contract.MangaManager
import com.manga.mebaad.mangarelease.data.model.Category
import com.manga.mebaad.mangarelease.data.model.Item
import com.manga.mebaad.mangarelease.data.model.Release

class MangaManagerImpl : MangaManager {

    override fun createListRelease(items: List<Item>, category: Category): List<Release> {

        var releases: MutableList<Release> = mutableListOf<Release>()
        if (items != null) {
            for (item in items) {
                releases.add(Release(item.title,retrieveUrlCover(item.description),retrieveSummary(item.description)))
            }
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


    fun splitTitle(title: String) {
        val regex = """(tome)\s[0-9]*""".toRegex()
        val matchResult = regex.find(title)
        Log.d("RSS : ", title)
        if(matchResult != null)
            Log.d("RSS : ", matchResult.value)
    }
}