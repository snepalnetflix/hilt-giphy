package com.example.hiltgiphy.net.api

import com.example.hiltgiphy.data.api.GifEntity
import com.example.hiltgiphy.data.api.Meta
import com.example.hiltgiphy.data.api.Pagination
import kotlinx.serialization.Serializable

/**
 * Result of a trending or search query.
 */
@Serializable
data class FeedResponse(
    val entities: List<GifEntity>,
    val pagination: Pagination,
    val meta: Meta
)