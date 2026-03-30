package com.newgen.tweetsjsonbinapplication.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newgen.tweetsjsonbinapplication.repo.TweetsRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(
    private val repo: TweetsRepository
    /*,private val savedStateHandle: SavedStateHandle*/) : ViewModel(){

    val tweets = repo.tweets


//    init{
//        viewModelScope.launch {
//            val category = savedStateHandle.get<String>("category") ?: "android"
//            repo.getTweets(category)
//        }
//    }

    fun getTweets(category: String){
        viewModelScope.launch {
            repo.getTweets(category)
        }
    }
}