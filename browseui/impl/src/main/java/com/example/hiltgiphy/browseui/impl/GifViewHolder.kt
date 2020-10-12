package com.example.hiltgiphy.browseui.impl

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hiltgiphy.data.api.GifEntity
import kotlin.math.abs

class GifViewHolder private constructor(itemView: View) : ViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.card_image_view)
    private var gifEntity: GifEntity? = null

    init {
        itemView.setOnClickListener(this::onItemClicked)
    }

    fun clear() {
        Glide.with(imageView.context).clear(imageView)
        imageView.setImageDrawable(null)
        itemView.contentDescription = null
    }

    fun bindTo(item: GifEntity, cardWidth: Int) {
        gifEntity = item
        imageView.setBackgroundColor(Color.argb(255, 0, 0, 0))
        val images = item.images
        if (images == null) {
            Log.d(TAG, "GIF item has no images")
            loadErrorState()
            return
        }
        val fixedWidthImage = images.fixedWidth
        if (fixedWidthImage == null) {
            Log.d(TAG, "GIF item has no fixed width image")
            loadErrorState()
            return
        }
        val url: String = fixedWidthImage.url
        if (DEBUG && Log.isLoggable(TAG, Log.VERBOSE)) {
            Log.v(TAG, "loading URL: $url")
        }
        val imageWidth: Int = fixedWidthImage.width.toInt()
        val imageHeight: Int = fixedWidthImage.height.toInt()
        val aspectRatio = imageWidth.toDouble() / imageHeight.toDouble()
        val viewHeight = (cardWidth / aspectRatio).toInt()
        val imageLayoutParams = imageView.layoutParams
        imageLayoutParams.width = cardWidth
        imageLayoutParams.height = viewHeight
        imageView.layoutParams = imageLayoutParams
        val options: RequestOptions = RequestOptions().override(cardWidth, viewHeight)
            .placeholder(placeholderImage).error(errorImage)
        Glide.with(imageView).load(url).apply(options).into(imageView)
        itemView.contentDescription = item.title
    }

    private val placeholderImage: Drawable?
        get() {
            val index: Int = abs(gifEntity?.id.hashCode()) % PLACEHOLDER_COLORS.size
            if (PLACEHOLDER_DRAWABLES[index] == null) {
                PLACEHOLDER_DRAWABLES[index] = ColorDrawable(PLACEHOLDER_COLORS[index])
            }
            return PLACEHOLDER_DRAWABLES[index]
        }
    private val errorImage: Drawable?
        get() {
            if (errorDrawable == null) {
                errorDrawable = ColorDrawable(ERROR_COLOR)
            }
            return errorDrawable
        }

    private fun loadErrorState() {
        imageView.setBackgroundColor(Color.rgb(200, 50, 50))
    }

    private fun onItemClicked(view: View) {
        Log.d(TAG, "clicked item: $gifEntity")
        val context = view.context
        //context.startActivity(DetailsActivity.getIntentForEntity(context, gifEntity))
    }

    companion object {
        private const val TAG = "GifViewHolder"
        private const val DEBUG = false
        private val PLACEHOLDER_COLORS = intArrayOf(
            Color.rgb(0x00, 0xCC, 0xFF),
            Color.rgb(0xFF, 0x66, 0x66),
            Color.rgb(0x00, 0xFF, 0x99),
            Color.rgb(0x99, 0x33, 0xFF)
        )
        private val PLACEHOLDER_DRAWABLES = arrayOf<Drawable?>(
            null,
            null,
            null,
            null
        )
        private val ERROR_COLOR = Color.rgb(0xFF, 0x00, 0x00)
        private var errorDrawable: Drawable? = null
        fun createWithParentView(parentView: ViewGroup): GifViewHolder {
            val inflater = LayoutInflater.from(parentView.context)
            val itemView: View = inflater.inflate(R.layout.card_view, parentView, false)
            return GifViewHolder(itemView)
        }
    }


}
