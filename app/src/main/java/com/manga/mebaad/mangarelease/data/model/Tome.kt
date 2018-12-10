package com.manga.mebaad.mangarelease.data.model

import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(tableName = "tomes", primaryKeys = ["id", "mangaId"],
        foreignKeys = [
            ForeignKey(entity = Manga::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("mangaId"),
                onDelete = ForeignKey.CASCADE)])
data class Tome(val id: Int,
                val mangaId: Long,
                val description: String,
                val urlCover: String) {
    constructor() : this(0, 0, "", "")
}