package com.example.hiltgiphy.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pagination(
    var offset: Int = 0,

    @SerialName("total_count")
    var totalCount: Int = 0,

    var count: Int = 0,
) {
    override fun toString(): String {
        return "offset: $offset, count: $count, of total: $totalCount"
    }
}