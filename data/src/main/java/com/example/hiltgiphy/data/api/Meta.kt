package com.example.hiltgiphy.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    val msg: String? = null,

    val status: Int = 0,

    @SerialName("response_id")
    val responseId: String? = null
)
