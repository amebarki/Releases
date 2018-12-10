package com.manga.mebaad.mangarelease.ui.fragment


import android.os.Bundle
import android.util.Log
import android.util.Log.e
import android.view.*
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.base.activity.showToast
import com.manga.mebaad.mangarelease.base.fragment.BaseFragment
import com.manga.mebaad.mangarelease.data.model.Release
import com.manga.mebaad.mangarelease.data.navigator.Navigator
import com.manga.mebaad.mangarelease.ui.adapter.ReleaseAdapter
import com.manga.mebaad.mangarelease.ui.presenter.ReleasePresenter
import com.manga.mebaad.mangarelease.ui.view.ReleaseView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_release.*


class ReleaseFragment : BaseFragment(), ReleaseView {

    private lateinit var releasePresenter: ReleasePresenter
    private lateinit var releaseMenu: Menu


    //region [** VIEW METHODS **]

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        overwriteToolbar()
        releasePresenter = Navigator.instance().initReleasePresenter(this)
        e("ReleaseFragment", "Second Begin")

        return inflater.inflate(R.layout.fragment_release, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        e("ReleaseFragment", "Begin")
        releasePresenter.loadSeinenKurokawa()
        //releasePresenter.loadShonenKurokawa()
    }
    //endregion


    //region [** INTERFACE METHODS **]
    override fun showListRelease(releases: List<Release>) {
        release_recycler_view.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity!!.applicationContext, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false)
        release_recycler_view.adapter = ReleaseAdapter(releases, true) { release: Release, isChecked: Boolean -> releaseItemClicked(release, isChecked) }
        e("favorite","show list release method")
        releasePresenter.checkFavoriteManga()

    }

    override fun updateStatusRelease(statusList: List<Int>) {
        e("favorite", "update status")
        e("favorite","size : ${statusList.size}")
        for (status in statusList) {
            ReleaseAdapter.itemStateArray.append(status,true)
            release_recycler_view.adapter!!.notifyItemChanged(status)
        }
    }

    //endregion

    //region [** OPTION MENU METHODS **]
    override fun overwriteToolbar() {
        activity!!.activity_toolbar.title = "Manga Releases"
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        releaseMenu = menu!!
        releaseMenu.findItem(R.id.action_sort).isVisible = true
        releaseMenu.findItem(R.id.action_edit).isVisible = false
        releaseMenu.findItem(R.id.action_cancel).isVisible = false
        releaseMenu.findItem(R.id.action_confirm).isVisible = false
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.action_sort) {
            activity!!.showToast("Sort Action")
            releasePresenter.deleteAllTables()
        }
        return super.onOptionsItemSelected(item)
    }

    //endregion

    //region [** ITEM METHODS **]
    private fun releaseItemClicked(release: Release, isChecked: Boolean) {
        activity!!.showToast("Clicked : ${release.title}, favorite : $isChecked")
        releasePresenter.addToLibrary(release)
    }
    //endregion


}
