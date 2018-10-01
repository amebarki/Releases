package com.manga.mebaad.mangarelease.data.model

import java.util.*

/**
 * Created by Adam on 25/09/2018.
 */




data class Feed(val url : String, val title : String,  val link : String,  val author : String,  val description : String,  val image : String)

data class Item(val title : String,val pubdate : String,val link : String,val guid : String,val author: String,val thumbnail : String, val description : String,val content : String,val categories : List<Objects>)

data class RSSObject(val status: String, val feed : Feed, val items : List<Item>)