package com.manga.mebaad.mangarelease.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tomes")
data class Tome(@PrimaryKey(autoGenerate = false) val id: Int,
                val mangaId: Long,
                val description: String,
                val urlCover: String) {
    constructor() : this(0, 0, "", "")
}