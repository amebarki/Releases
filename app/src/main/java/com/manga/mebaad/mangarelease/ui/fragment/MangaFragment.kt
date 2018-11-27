package com.manga.mebaad.mangarelease.ui.fragment


import android.os.Bundle
import android.view.*
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.base.activity.showToast
import com.manga.mebaad.mangarelease.base.fragment.BaseFragment
import com.manga.mebaad.mangarelease.data.model.Category
import com.manga.mebaad.mangarelease.data.model.Manga
import com.manga.mebaad.mangarelease.data.model.Tome
import com.manga.mebaad.mangarelease.data.navigator.Navigator
import com.manga.mebaad.mangarelease.ui.adapter.MangaAdapter
import com.manga.mebaad.mangarelease.ui.presenter.MangaPresenter
import com.manga.mebaad.mangarelease.ui.view.MangaView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_manga.*


class MangaFragment : BaseFragment(), MangaView {


    private lateinit var mangaMenu: Menu
    private lateinit var mangaPresenter: MangaPresenter
    private lateinit var mangaAdapter: MangaAdapter

    //region [** VIEW METHODS **]
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        overwriteToolbar()
        mangaPresenter = Navigator.instance().initMangaPresenter(this)


        return inflater.inflate(R.layout.fragment_manga, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    //endregion

    //region [** INTERFACE METHODS **]

    override fun displayMangas(mangas: List<Tome>) {
        mangaAdapter = MangaAdapter(mangas, View.INVISIBLE, true){ tomeId: Int, position: Int, isChecked: Boolean -> tomeItemClicked(tomeId, position, isChecked) }

        manga_grid_layout.layoutManager = androidx.recyclerview.widget.GridLayoutManager(activity!!.applicationContext, 3)
        manga_grid_layout.adapter = mangaAdapter
        manga_title_text_view.text = "Example of Manga"

    }

    override fun displayEditMode(itemState: Boolean, editState: Int) {
        mangaMenu.findItem(R.id.action_confirm).isVisible = itemState
        mangaMenu.findItem(R.id.action_cancel).isVisible = itemState
        mangaMenu.findItem(R.id.action_edit).isVisible = !itemState

        mangaAdapter.visibility = editState
        mangaAdapter.initArray = true

        manga_grid_layout.adapter!!.notifyDataSetChanged()

    }
    //endregion


    //region [** ITEMS METHODS **]
    private fun tomeItemClicked(tomeNumber: Int, position: Int, isChecked: Boolean) {
        activity!!.showToast("Clicked : tome $tomeNumber, position : $position, isChecked : $isChecked")
        // open dialog box to display detail of tome
    }
    //endregion


    //region [** OPTIONS MENU METHODS **]
    override fun overwriteToolbar() {
        activity!!.activity_toolbar.title = "Manga"

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        mangaMenu = menu!!
        mangaMenu.findItem(R.id.action_sort).isVisible = false
        mangaMenu.findItem(R.id.action_edit).isVisible = true
        mangaMenu.findItem(R.id.action_cancel).isVisible = false
        mangaMenu.findItem(R.id.action_confirm).isVisible = false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_edit -> {
                mangaPresenter.launchEdit()
                activity!!.showToast("Edit Action")
            }
            R.id.action_confirm -> {
                activity!!.showToast("Confirm Edit Action")
                mangaPresenter.confirmEdit()
            }
            R.id.action_cancel -> {
                activity!!.showToast("Cancel Edit Action")
                mangaPresenter.cancelEdit()
            }
            else -> {
                activity!!.showToast("Error")
            }
        }
        return super.onOptionsItemSelected(item)
    }
    //endregion

}
