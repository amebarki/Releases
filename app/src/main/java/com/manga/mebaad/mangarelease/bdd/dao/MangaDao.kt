package com.manga.mebaad.mangarelease.data.bdd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.manga.mebaad.mangarelease.data.model.Manga
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MangaDao {

    @Query("SELECT * from mangas")
    fun getAll(): Single<List<Manga>>

    @Insert(onConflict = REPLACE)
    fun insert(manga: Manga) : Completable

//    @Query("DELETE from mangas")
//    fun deleteAll() : Integer
}