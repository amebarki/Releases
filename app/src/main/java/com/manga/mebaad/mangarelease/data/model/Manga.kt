package com.manga.mebaad.mangarelease.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "mangas",indices = arrayOf(Index(value = "name",unique = true)))
data class Manga(var name: String,
                 var category: Category,
                 @Ignore var tomes : MutableList<Tome>){
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0


     constructor():this("",Category.SEINEN, mutableListOf())
}