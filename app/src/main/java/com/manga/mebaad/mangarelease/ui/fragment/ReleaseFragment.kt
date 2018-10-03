package com.manga.mebaad.mangarelease.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.base.activity.showToast
import com.manga.mebaad.mangarelease.data.model.Release
import com.manga.mebaad.mangarelease.data.navigator.Navigator
import com.manga.mebaad.mangarelease.ui.adapter.ReleaseAdapter
import com.manga.mebaad.mangarelease.ui.presenter.ReleasePresenter
import com.manga.mebaad.mangarelease.ui.view.ReleaseView
import kotlinx.android.synthetic.main.fragment_release.*


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

        release_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext,LinearLayoutManager.HORIZONTAL,false)
        release_recycler_view.adapter = ReleaseAdapter(releases,{release :  Release, isChecked : Boolean -> releaseItemClicked(release,isChecked)} )


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        releasePresenter = Navigator.Instance().initReleasePresenter(activity!!.applicationContext, this)
        releasePresenter.loadSeinenKurokawa()
        releasePresenter.loadShonenKurokawa()
        return inflater.inflate(R.layout.fragment_release, container, false)
    }


    private fun releaseItemClicked(release : Release,isChecked : Boolean){
        activity!!.showToast("Clicked : ${release.title}, favorite : ${isChecked}")

    }

}
