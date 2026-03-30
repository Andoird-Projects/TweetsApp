package com.newgen.tweetsjsonbinapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newgen.tweetsjsonbinapplication.repo.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val repo: TweetsRepository): ViewModel(){

    val categories = repo.categories

    init {
        viewModelScope.launch {
            repo.getCategories()
        }
    }
}