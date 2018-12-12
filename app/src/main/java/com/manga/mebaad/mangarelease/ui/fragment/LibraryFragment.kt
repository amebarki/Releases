package com.manga.mebaad.mangarelease.ui.fragment


import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.*
import androidx.navigation.findNavController
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.base.activity.showToast
import com.manga.mebaad.mangarelease.base.fragment.BaseFragment
import com.manga.mebaad.mangarelease.data.model.Manga
import com.manga.mebaad.mangarelease.data.navigator.Navigator
import com.manga.mebaad.mangarelease.ui.adapter.LibraryAdapter
import com.manga.mebaad.mangarelease.ui.presenter.LibraryPresenter
import com.manga.mebaad.mangarelease.ui.view.LibraryView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_library.*


class LibraryFragment : BaseFragment(), LibraryView {


    private lateinit var libraryPresenter: LibraryPresenter
    private lateinit var libraryAdapter: LibraryAdapter
    private lateinit var libraryMenu: Menu


    //region [** VIEW METHODS **]
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        overwriteToolbar()
        libraryPresenter = Navigator.instance().initLibraryPresenter(this)

        return inflater.inflate(R.layout.fragment_library, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        libraryPresenter.retrieveLibrary()
    }
    //endregion


    //region [** INTERFACE METHODS **]
    override fun displayMangas(mangas: List<Manga>) {

        libraryAdapter = LibraryAdapter(mangas, View.INVISIBLE, true) { mangaTitle: String, position: Int, isChecked: Boolean -> mangaItemClicked(mangaTitle, position, isChecked) }
        library_recycler_view.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity!!.applicationContext, androidx.recyclerview.widget.LinearLayoutManager.VERTICAL, false)
        library_recycler_view.adapter = libraryAdapter
    }

    override fun displayEditMode(itemState: Boolean, editState: Int) {
        libraryMenu.findItem(R.id.action_confirm).isVisible = itemState
        libraryMenu.findItem(R.id.action_cancel).isVisible = itemState
        libraryMenu.findItem(R.id.action_edit).isVisible = !itemState

        libraryAdapter.visibility = editState
        libraryAdapter.initArray = true
        library_recycler_view.adapter!!.notifyDataSetChanged()

    }
    //endregion


    //region [** ITEMS METHODS **]

    private fun mangaItemClicked(mangaTitle: String, position: Int, isChecked: Boolean) {
        activity!!.showToast("Clicked : $mangaTitle, position : $position, isChecked : $isChecked")
        view!!.findNavController().navigate(R.id.action_libraryFragment_to_mangaFragment)
    }

    //endregion


    //region [** OPTIONS MENU METHODS **]

    override fun overwriteToolbar() {
        activity!!.activity_toolbar.title = "My Library"
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        libraryMenu = menu!!
        libraryMenu.findItem(R.id.action_sort).isVisible = false
        libraryMenu.findItem(R.id.action_edit).isVisible = true
        libraryMenu.findItem(R.id.action_cancel).isVisible = false
        libraryMenu.findItem(R.id.action_confirm).isVisible = false

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_edit -> {
                libraryPresenter.launchEdit()
                activity!!.showToast("Edit Action")
            }
            R.id.action_confirm -> {
                activity!!.showToast("Confirm Edit Action")
                libraryPresenter.confirmEdit()
            }
            R.id.action_cancel -> {
                activity!!.showToast("Cancel Edit Action")
                libraryPresenter.cancelEdit()
            }
            else -> {
                activity!!.showToast("Error")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //endregion


}
