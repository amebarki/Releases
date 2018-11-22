package com.manga.mebaad.mangarelease.data.model

import androidx.room.TypeConverter

/**
 * Created by Adam on 23/09/2018.
 */
enum class Category(val value: Int) {
    SHOJO(0),
    SHONEN(1),
    SEINEN(2),
    HUMOR(3);

    companion object {
        private val map = Category.values().associateBy(Category::value);
    }

}


class CategoryConverter {


    private val map = Category.values().associateBy(Category::value)

    @TypeConverter
    fun fromCategory(category: Category): Int? =
            category.ordinal


    @TypeConverter
    fun fromInt(value: Int): Category? =
            map[value]

}