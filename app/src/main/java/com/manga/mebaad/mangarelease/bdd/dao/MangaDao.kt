package com.manga.mebaad.mangarelease.data.bdd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.ABORT
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.manga.mebaad.mangarelease.data.model.Manga
import com.manga.mebaad.mangarelease.data.model.Tome
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MangaDao {

    @Query("SELECT * from mangas")
    fun getAllManga(): Single<List<Manga>>

    @Query("SELECT * FROM mangas WHERE name = :title")
    fun getManga(title : String) : Single<Manga>

    @Query("SELECT * FROM tomes WHERE mangaId = :idManga")
    fun getTomes(idManga : Long) : Single<List<Tome>>

    @Insert(onConflict = ABORT)
    fun insertManga(manga: Manga): Single<Long>

    @Insert(onConflict = ABORT)
    fun insertTomes(tomes : List<Tome>) : Single<List<Long>>


    @Query("DELETE FROM mangas")
    fun deleteMangaTable()

    @Query("DELETE FROM tomes")
    fun deleteTomeTable()

}