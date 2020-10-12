package com.example.hiltgiphy.data.api

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Images(
    @Embedded(prefix = "original_")
    var original: OriginalImage? = null,

    @SerialName("fixed_width")
    @Embedded(prefix = "fixed_width_")
    var fixedWidth: FixedWidthImage? = null,

    @SerialName("fixed_width_still")
    @Embedded(prefix = "fixed_width_still_")
    var fixedWidthStill: FixedWidthStillImage? = null
) {
    override fun toString(): String {
        return "fixedWidthStill: $fixedWidthStill"
    }
}
