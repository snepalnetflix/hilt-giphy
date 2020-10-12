package com.example.hiltgiphy.data.api

import kotlinx.serialization.Serializable

@Serializable
data class OriginalImage(
    var url: String? = null,
    var width: String? = null,
    var height: String? = null,
)
