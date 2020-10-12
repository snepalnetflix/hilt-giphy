package com.example.hiltgiphy.data.api

import kotlinx.serialization.Serializable

@Serializable
data class FixedWidthImage(
    var url: String = "",
    var width: String = "",
    var height: String = ""
) {

    override fun toString(): String {
        return "size: $width x $height"
    }
}
