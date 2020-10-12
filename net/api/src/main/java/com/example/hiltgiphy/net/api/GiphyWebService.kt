package com.example.hiltgiphy.net.api

import retrofit2.Call

interface GiphyWebService {
    suspend fun fetchTrending(limit: Int, offset: Int): Call<FeedResponse>

    suspend fun search(limit: Int, offset: Int, query: String): Call<FeedResponse>
}
