package com.manga.mebaad.mangarelease.data.model

import androidx.room.Entity


@Entity(tableName = "tomes",primaryKeys = ["id","mangaId"])
data class Tome(val id: Int,
                val mangaId: Long,
                val description: String,
                val urlCover: String) {
    constructor() : this(0, 0, "", "")
}