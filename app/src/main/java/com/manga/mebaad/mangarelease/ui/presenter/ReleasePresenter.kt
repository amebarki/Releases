package com.manga.mebaad.mangarelease.ui.presenter

import android.content.Context
import com.manga.mebaad.mangarelease.MangaApplication
import com.manga.mebaad.mangarelease.domain.UseCase.LoadSeinenKurokawaUseCase
import com.manga.mebaad.mangarelease.data.model.Item
import com.manga.mebaad.mangarelease.data.model.Release
import com.manga.mebaad.mangarelease.domain.UseCase.LoadShonenKurokawaUseCase
import com.manga.mebaad.mangarelease.ui.view.ReleaseView
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ReleasePresenter(val context : Context, val releaseView: ReleaseView){

    private  var releasesList : MutableList<Release> = mutableListOf()
    val apiService = MangaApplication.getApiMangaService()


    fun loadSeinenKurokawa(){
        LoadSeinenKurokawaUseCase(apiService).execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object  : SingleObserver<List<Release>>{
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

    fun loadShonenKurokawa(){
        LoadShonenKurokawaUseCase(apiService).execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object  : SingleObserver<List<Release>>{
                    override fun onSuccess(shonenReleases: List<Release>) {
                        releasesList.addAll(shonenReleases)
                        releaseView.showListRelease(releasesList)
                    }
                    override fun onSubscribe(d: Disposable) {}

                    override fun onError(e: Throwable) {}
                })
    }


}