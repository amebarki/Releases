package com.manga.mebaad.mangarelease.ui.presenter

import com.manga.mebaad.mangarelease.MangaApplication
import com.manga.mebaad.mangarelease.base.presenter.BasePresenter
import com.manga.mebaad.mangarelease.data.manager.contract.MangaManager
import com.manga.mebaad.mangarelease.data.model.Manga
import com.manga.mebaad.mangarelease.data.model.Release
import com.manga.mebaad.mangarelease.data.navigator.Navigator
import com.manga.mebaad.mangarelease.domain.RssUseCase.LoadSeinenKurokawaUseCase
import com.manga.mebaad.mangarelease.domain.RssUseCase.LoadShonenKurokawaUseCase
import com.manga.mebaad.mangarelease.ui.view.ReleaseView
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ReleasePresenter(val releaseView: ReleaseView) : BasePresenter() {


    private var releasesList: MutableList<Release> = mutableListOf()
    private val apiService = MangaApplication.getApiMangaService()
    private val mangaDatabase = MangaApplication.getMangaDatabase()
    private val mangaManager: MangaManager = Navigator.instance().getMangaManager()


    fun loadSeinenKurokawa() {
        LoadSeinenKurokawaUseCase(apiService).execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<Release>> {
                    override fun onSuccess(seinenReleases: List<Release>) {
                        releasesList.addAll(seinenReleases)
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onError(e: Throwable) {
                        releaseView.showError(e.message.toString())
                    }
                })
    }

    fun loadShonenKurokawa() {
        LoadShonenKurokawaUseCase(this.apiService).execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<Release>> {
                    override fun onSuccess(shonenReleases: List<Release>) {
                        releasesList.addAll(shonenReleases)
                        releaseView.showListRelease(releasesList)
                    }

                    override fun onSubscribe(d: Disposable) {}

                    override fun onError(e: Throwable) {}
                })
    }

    fun addToLibrary(release: Release) {

        var newManga = mangaManager.createManga(release)

        mangaDatabase.MangaDao().insert(newManga).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Long> {
                    override fun onSuccess(t: Long) {
                        // find Tomes of the new manga
                        releaseView.showError("onSuccess id insert: " + t.toString())
                    }
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        releaseView.showError("onError : " + e.message)
                    }
                })
    }


    fun getAllMangas() {
        mangaDatabase.MangaDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<Manga>> {
                    override fun onSuccess(mangaList: List<Manga>) {
                        if (mangaList != null) {
                            releaseView.showError("onSuccess : " + mangaList.size.toString())
                            releaseView.showError("onSuccess : " + mangaList[2].name)
                            releaseView.showError("onSuccess : " + mangaList[3].name)
                        }
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        releaseView.showError("onError : " + e.message.toString())
                    }
                })
    }

    //region [** BASE METHODS **]
    override fun launchEdit() {
    }

    override fun cancelEdit() {
    }

    override fun confirmEdit() {
    }
//endregion
}