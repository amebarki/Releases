package com.manga.mebaad.mangarelease

import android.app.Application
import com.manga.mebaad.mangarelease.api.service.ApiMangaService
import com.manga.mebaad.mangarelease.data.navigator.Navigator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class MangaApplication : Application() {


    init {
        instance = this
    }

    companion object {
        private lateinit var apiMangaService : ApiMangaService
        private var instance: MangaApplication? = null

        fun instance(): Application {

            return instance!!
        }

        fun getApiMangaService() : ApiMangaService {
            return apiMangaService
        }
    }



    override fun onCreate() {
        super.onCreate()
        val logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)

        val builder = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(" https://api.rss2json.com/v1/")


        val retrofit = builder
                .client(
                        httpClient.build()
                )
                .build()
        apiMangaService = retrofit.create(ApiMangaService::class.java)
        Navigator.instance().init()
    }



}