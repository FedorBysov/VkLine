package com.example.composestudy1.ui.theme

import androidx.activity.compose.BackHandler
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
import com.example.composestudy1.domain.FeedPost

@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    paddingValues: PaddingValues
) {

    val screenState = viewModel.screenState.observeAsState(HomeScreenState.Initial)

    val currentState = screenState.value

    when (currentState) {
        is HomeScreenState.Posts -> {
            FeedPosts(
                viewModel = viewModel,
                paddingValues = paddingValues,
                posts = currentState.posts
            )
        }

        is HomeScreenState.Comments -> {
            CommentScreen(
                feedPost = currentState.feedPost,
                comments = currentState.comments,
                onBackPressed = {
                    viewModel.closeComments()
                }
            )
            BackHandler {
                viewModel.closeComments()
            }
        }

        else -> {}
    }
}

@Composable
private fun FeedPosts(
    posts: List<FeedPost>,
    viewModel: MainViewModel,
    paddingValues: PaddingValues
) {
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
            items = posts,
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
                onCommentClickListener = {
                    viewModel.showComments(feedPost = feedPost)
                },
                onLikeClickListener = { statisticItem ->
                    viewModel.updateCount(feedPost, statisticItem)
                },
            )
        }
    }
}