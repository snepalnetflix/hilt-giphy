package com.example.hiltgiphy.browseui.impl

import androidx.recyclerview.widget.DiffUtil
import com.example.hiltgiphy.data.api.GifEntity

object GifDiffCallback : DiffUtil.ItemCallback<GifEntity>() {
    override fun areItemsTheSame(oldItem: GifEntity, newItem: GifEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GifEntity, newItem: GifEntity): Boolean {
        // TODO - implement equals and hash in the each data class. (We can get this for free once
        // we switch to AutoValue).
        return oldItem.id == newItem.id
    }
}