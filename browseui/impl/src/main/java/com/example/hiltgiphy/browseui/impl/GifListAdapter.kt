package com.example.hiltgiphy.browseui.impl

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.hiltgiphy.data.api.GifEntity
import javax.inject.Inject

class GifListAdapter @Inject constructor(
) : PagingDataAdapter<GifEntity, GifViewHolder>(GifDiffCallback) {
    var cardWidth = 0

    override fun onBindViewHolder(viewHolder: GifViewHolder, position: Int) {
        val gifEntity: GifEntity? = getItem(position)
        if (gifEntity == null) {
            viewHolder.clear()
        } else {
            viewHolder.bindTo(gifEntity, cardWidth)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        return GifViewHolder.createWithParentView(parent)
    }

    init {
        setHasStableIds(true)
    }
}
