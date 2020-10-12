package com.example.hiltgiphy.net.impl

import com.example.hiltgiphy.net.api.FeedResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyWebServiceInternal {
    /**
     * curl "http://api.giphy.com/v1/gifs/trending?api_key=abc&limit=2"
     */
    @GET("/v1/gifs/trending")
    fun trending(
        @Query("api_key") api_key: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Call<FeedResponse>

    @GET("/v1/gifs/search")
    fun search(
        @Query("api_key") api_key: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("q") query: String
    ): Call<FeedResponse>
}