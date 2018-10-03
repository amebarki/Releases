package com.manga.mebaad.mangarelease.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.base.activity.showToast
import com.manga.mebaad.mangarelease.ui.adapter.LibraryAdapter
import com.manga.mebaad.mangarelease.ui.presenter.LibraryPresenter
import com.manga.mebaad.mangarelease.ui.view.LibraryView
import kotlinx.android.synthetic.main.fragment_library.*


class LibraryFragment : Fragment(), LibraryView {

    private lateinit var libraryPresenter: LibraryPresenter

    private var mangaList: MutableList<String> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //libraryPresenter = Navigator.Instance().initLibraryPresenter(this)
        initList()

        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var library_recycler_view = view!!.findViewById<RecyclerView>(R.id.library_recycler_view)
        library_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext,LinearLayoutManager.VERTICAL,false)
        library_recycler_view.adapter = LibraryAdapter(mangaList,{ mangaTitle :  String, position : Int -> mangaItemClicked(mangaTitle,position)} )
    }

    private fun mangaItemClicked(mangaTitle: String, position: Int) {
        activity!!.showToast("Clicked : ${mangaTitle}, position : ${position}")

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
