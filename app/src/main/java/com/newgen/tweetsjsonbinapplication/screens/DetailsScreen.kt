package com.newgen.tweetsjsonbinapplication.screens

import android.telecom.Call
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.newgen.tweetsjsonbinapplication.viewmodels.TweetsViewModel


@Composable
fun DetailsScreen(category: String) {
    val tweetsViewModel: TweetsViewModel = hiltViewModel()

    val tweets = tweetsViewModel.tweets.collectAsState()

    LaunchedEffect(key1 = Unit) {
        tweetsViewModel.getTweets(category)
    }

    LazyColumn (
        contentPadding = PaddingValues(30.dp)
    )
    {
        items(tweets.value){item ->
            SingleTweet(item.text)
        }
    }
}




@Preview
@Composable
fun SingleTweet(tweet: String = "default") {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            ,
        border = BorderStroke(1.dp, Color(0xFFCCCCCC))
    ) {
        Text(
            text = tweet,
//            fontSize = 20.sp,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}

