package com.manga.mebaad.mangarelease.ui.fragment


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.base.activity.showToast
import com.manga.mebaad.mangarelease.ui.adapter.LibraryAdapter
import com.manga.mebaad.mangarelease.ui.presenter.LibraryPresenter
import com.manga.mebaad.mangarelease.ui.view.LibraryView
import kotlinx.android.synthetic.main.activity_home.*


class LibraryFragment : BaseFragment(), LibraryView {

    private lateinit var libraryPresenter: LibraryPresenter

    private var mangaList: MutableList<String> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //libraryPresenter = Navigator.Instance().initLibraryPresenter(this)
        initList()
        overwriteToolbar()
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        var library_recycler_view = view.findViewById<RecyclerView>(R.id.library_recycler_view)
        library_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext, LinearLayoutManager.VERTICAL, false)
        library_recycler_view.adapter = LibraryAdapter(mangaList, { mangaTitle: String, position: Int -> mangaItemClicked(mangaTitle, position) })
    }


    private fun mangaItemClicked(mangaTitle: String, position: Int) {
        activity!!.showToast("Clicked : ${mangaTitle}, position : ${position}")

    }


    override fun overwriteToolbar() {
        activity!!.activity_toolbar.title = "My Library"

    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        menu!!.findItem(R.id.action_sort).isVisible = false
        menu.findItem(R.id.action_edit).isVisible = true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.action_edit) {
            activity!!.showToast("Edit Action")
        }
        return super.onOptionsItemSelected(item)
    }


    private fun initList() {
        Log.d("LIBRARY", "INIT LIST")
        mangaList.add("One Piece")
        mangaList.add("Rudolf Turkey")
        mangaList.add("Kingdom")
        mangaList.add("Eyeshield 21")
        mangaList.add("Arms Peddler")
        mangaList.add("Saint Seiya - The Lost Canvas - Chronicles")
        mangaList.add("Platinum End")
        mangaList.add("Jackals")
        mangaList.add("Warlords")
        mangaList.add("Tsubasa Reservoir Chronicles")
        mangaList.add("Beelzebub")
        mangaList.add("One Punch Man")
        mangaList.add("Blood Lad")
        mangaList.add("Sun Ken Rock")
        mangaList.add("Origin")
    }
}
