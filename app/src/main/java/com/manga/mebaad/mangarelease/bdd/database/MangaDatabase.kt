package com.manga.mebaad.mangarelease.bdd.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.manga.mebaad.mangarelease.data.bdd.dao.MangaDao
import com.manga.mebaad.mangarelease.data.model.CategoryConverter
import com.manga.mebaad.mangarelease.data.model.Manga

@TypeConverters(CategoryConverter::class)
@Database(entities = [Manga::class], version = 3)
abstract class MangaDatabase : RoomDatabase(){

    abstract fun MangaDao(): MangaDao



    companion object {
        private var INSTANCE: MangaDatabase? = null

        fun getInstance(context: Context): MangaDatabase? {
            if (INSTANCE == null) {
                synchronized(MangaDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            MangaDatabase::class.java, "weather.db")
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}

