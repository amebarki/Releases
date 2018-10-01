package com.manga.mebaad.mangarelease.ui.presenter

import android.content.Context
import android.util.Log
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


    private val RSS_LINK = "https://api.rss2json.com/v1/api.json?rss_url=https://www.kurokawa.fr/rss-subscribe/books-seinen/rss.xml"
    private val RSS_TO_JSON_API = " ";

    val apiService = MangaApplication.getApiMangaService()


    fun loadSeinenKurokawa(){
        LoadSeinenKurokawaUseCase(apiService).execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object  : SingleObserver<List<Release>>{
                    override fun onSuccess(releases: List<Release>) {
                        releaseView.showListRelease(releases)
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
                .subscribe(object  : SingleObserver<List<Item>>{
                    override fun onSuccess(t: List<Item>) {
                        Log.d("RSS","There are ${t.size} objects")
                    }
                    override fun onSubscribe(d: Disposable) {}

                    override fun onError(e: Throwable) {}
                })
    }




}