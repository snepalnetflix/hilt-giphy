package com.example.hiltgiphy.data.api

import kotlinx.serialization.Serializable

@Serializable
data class FixedWidthStillImage(
    var url: String? = null,
    var width: String? = null,
    var height: String? = null
) {
    override fun toString(): String {
        return "width: $width, height: $height, url: $url"
    }
}