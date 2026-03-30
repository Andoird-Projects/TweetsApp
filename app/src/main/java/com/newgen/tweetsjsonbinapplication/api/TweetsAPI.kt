package com.newgen.tweetsjsonbinapplication.api

import com.newgen.tweetsjsonbinapplication.models.CategoriesList
import com.newgen.tweetsjsonbinapplication.models.TweetsList
import com.newgen.tweetsjsonbinapplication.models.TweetsListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header


interface TweetsAPI {

    @GET("/v3/b/69c25becaa77b81da91406df?meta=false")
    suspend fun getTweetsforCategory(@Header("X-JSON-Path") category: String): Response<TweetsList>

    @GET("/v3/b/69c4d7f9c3097a1dd55f9a74?meta=false")
    suspend fun getCategories(): Response<CategoriesList>
}