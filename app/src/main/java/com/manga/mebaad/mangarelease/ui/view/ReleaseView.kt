package com.manga.mebaad.mangarelease.ui.view

import com.manga.mebaad.mangarelease.base.view.BaseView
import com.manga.mebaad.mangarelease.data.model.Release

interface ReleaseView : BaseView {
    fun showListRelease(releases: List<Release>)
}