package com.manga.mebaad.mangarelease.data.manager.contract

import com.manga.mebaad.mangarelease.data.model.Category
import com.manga.mebaad.mangarelease.data.model.Item
import com.manga.mebaad.mangarelease.data.model.Release

interface MangaManager {

    fun createListRelease(items : List<Item>,category: Category) : List<Release>


    fun retrieveUrlCover(description : String) : String

    fun retrieveSummary(description: String) : String

}