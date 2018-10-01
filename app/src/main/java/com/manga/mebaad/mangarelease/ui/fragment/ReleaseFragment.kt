package com.manga.mebaad.mangarelease.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.base.activity.showToast
import com.manga.mebaad.mangarelease.data.model.Release
import com.manga.mebaad.mangarelease.data.navigator.Navigator
import com.manga.mebaad.mangarelease.ui.presenter.ReleasePresenter
import com.manga.mebaad.mangarelease.ui.view.ReleaseView


class ReleaseFragment : Fragment(), ReleaseView {


    private lateinit var releasePresenter: ReleasePresenter

    override fun showXmlExample() {
        activity?.showToast("showExample")
    }


    override fun showError(errorMessage: String) {
        super.showError(errorMessage)
        activity?.showToast(errorMessage)
    }

    override fun showListRelease(releases: List<Release>) {
            for(release in releases){
                Log.d("RSS",release.title)
                Log.d("RSS",release.urlCover)
                Log.d("RSS",release.summary)
            }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        releasePresenter = Navigator.Instance().initReleasePresenter(activity!!.applicationContext, this)
        releasePresenter.loadSeinenKurokawa()

        return inflater.inflate(R.layout.fragment_release, container, false)
    }
}
