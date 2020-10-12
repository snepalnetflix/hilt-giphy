package com.example.hiltgiphy.net.impl

import com.example.hiltgiphy.net.api.FeedResponse
import com.example.hiltgiphy.net.api.GiphyWebService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Call
import retrofit2.Retrofit

class GiphyWebServiceImpl : GiphyWebService {
    companion object {
        private const val API_KEY = "dc6zaTOxFJmzC"
        private const val GIPHY_API_URL = "https://api.giphy.com"
    }

    private val webService: GiphyWebServiceInternal by lazy { createGiphyWebServiceInternal() }

    override suspend fun fetchTrending(limit: Int, offset: Int): Call<FeedResponse> {
        return webService.trending(API_KEY, limit, offset)
    }

    override suspend fun search(limit: Int, offset: Int, query: String): Call<FeedResponse> {
        return webService.search(API_KEY, limit, offset, query)
    }

    private fun createGiphyWebServiceInternal(): GiphyWebServiceInternal {
        val contentType = "application/json".toMediaType()
        val jsonConverterFactory = Json.asConverterFactory(contentType)
        val retrofit = Retrofit.Builder().baseUrl(GIPHY_API_URL)
            .addConverterFactory(jsonConverterFactory)
            .build()

        return retrofit.create(GiphyWebServiceInternal::class.java)
    }
}
