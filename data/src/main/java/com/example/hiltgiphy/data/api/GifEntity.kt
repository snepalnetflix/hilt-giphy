package com.example.hiltgiphy.data.api

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class GifEntity(
    @PrimaryKey
    var offsetIndex: Int = 0,

    var isSearchResult: Boolean = false,

    var query: String? = null,

    var id: String? = null,

    var title: String? = null,

    @Embedded(prefix = "images_")
    var images: Images? = null,

    @Embedded(prefix = "pagination_")
    var pagination: Pagination? = null
) {

    override fun toString(): String {
        //return "id: " + id + ", title: " + title + ", images: " + images;
        return "<$offsetIndex> $title"
    }
}
