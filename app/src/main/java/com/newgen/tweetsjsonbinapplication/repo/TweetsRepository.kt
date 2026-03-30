package com.newgen.tweetsjsonbinapplication.repo

import com.newgen.tweetsjsonbinapplication.api.TweetsAPI
import com.newgen.tweetsjsonbinapplication.models.TweetsListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsRepository @Inject constructor(private val tweetsAPI: TweetsAPI) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories


    private val _tweets = MutableStateFlow<List<TweetsListItem>>(emptyList())
    val tweets: StateFlow<List<TweetsListItem>> = _tweets


    suspend fun getCategories(){
        val response = tweetsAPI.getCategories()

        if(response.isSuccessful && response.body()!=null){
            _categories.emit(response.body()!!.categories)
        }
    }

    suspend fun getTweets(category: String){
        val response = tweetsAPI.getTweetsforCategory("\$..tweets[?(@.category==\"$category\")]")

        if(response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)
        }
    }
}