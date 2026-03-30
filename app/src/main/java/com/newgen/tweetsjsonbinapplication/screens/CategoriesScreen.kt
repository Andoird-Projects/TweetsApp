package com.newgen.tweetsjsonbinapplication.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.newgen.tweetsjsonbinapplication.R
import com.newgen.tweetsjsonbinapplication.viewmodels.CategoriesViewModel
import kotlinx.coroutines.delay


@Composable
fun CategoriesScreen(navigateAction: (category: String) -> Unit) {

    val categoriesViewModel: CategoriesViewModel = hiltViewModel()
    val categories = categoriesViewModel.categories.collectAsState()

    if(categories.value.isEmpty()){
        Loader()
    }

    else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            items(categories.value) { category ->
                CategoryItem(category, navigateAction)
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun CategoryItem(category: String = "Default", navigateAction: (category: String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(painter = painterResource(R.drawable.category_bg),
                contentScale = ContentScale.Crop)
            .border(1.dp, Color(0xFFEEEEEE))
            .clickable{
                navigateAction(category)
            },
        contentAlignment = Alignment.BottomCenter

    ){
        Text(
            text = category,
            fontSize = 18.sp,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            modifier = Modifier.padding(vertical = 8.dp)
        )

    }
}


@Composable
fun Loader() {
    val degree = produceState(0){
        while (true){
            delay(30)
            value = (value+20)%360
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Loading Icon",
                modifier = Modifier
                    .size(60.dp)
                    .rotate(degree.value.toFloat())
            )
            Text(text = "Loading...")
        }
    }
}