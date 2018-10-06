package com.manga.mebaad.mangarelease.ui.fragment


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.base.activity.showToast
import com.manga.mebaad.mangarelease.data.model.Release
import com.manga.mebaad.mangarelease.data.navigator.Navigator
import com.manga.mebaad.mangarelease.ui.adapter.ReleaseAdapter
import com.manga.mebaad.mangarelease.ui.presenter.ReleasePresenter
import com.manga.mebaad.mangarelease.ui.view.ReleaseView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_release.*


class ReleaseFragment : BaseFragment(), ReleaseView {


    private lateinit var releasePresenter: ReleasePresenter
    private lateinit var releaseMenu : Menu

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
        overwriteToolbar()
        releasePresenter = Navigator.Instance().initReleasePresenter(this)

        return inflater.inflate(R.layout.fragment_release, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        releasePresenter.loadSeinenKurokawa()
        releasePresenter.loadShonenKurokawa()
    }

    private fun releaseItemClicked(release : Release,isChecked : Boolean){
        activity!!.showToast("Clicked : ${release.title}, favorite : $isChecked")

    }


    override fun overwriteToolbar(){
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
        }
        return super.onOptionsItemSelected(item)
    }

}
