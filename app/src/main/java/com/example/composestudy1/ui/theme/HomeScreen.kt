package com.example.composestudy1.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.example.composestudy1.MainViewModel

@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    paddingValues: PaddingValues
){

    val feedPosts = viewModel.feedPosts.observeAsState(listOf())

    LazyColumn(
        state = rememberLazyListState(),
        modifier = androidx.compose.ui.Modifier.padding(paddingValues),
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = feedPosts.value,
            key = { it.id }
        ) { feedPost ->


            PostCard(
                feedPost = feedPost,
                onViewsClickListener = { statisticItem ->
                    viewModel.updateCount(feedPost, statisticItem)
                },
                onShareClickListener = { statisticItem ->
                    viewModel.updateCount(feedPost, statisticItem)
                },
                onCommentClickListener = { statisticItem ->
                    viewModel.updateCount(feedPost, statisticItem)
                },
                onLikeClickListener = { statisticItem ->
                    viewModel.updateCount(feedPost, statisticItem)
                },
            )
        }
    }
}