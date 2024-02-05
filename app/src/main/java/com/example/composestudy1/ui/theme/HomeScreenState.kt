package com.example.composestudy1.ui.theme

import com.example.composestudy1.domain.FeedPost
import com.example.composestudy1.domain.PostComment

sealed class HomeScreenState{

    object Initial:HomeScreenState()

    data class Posts(val posts: List<FeedPost>):HomeScreenState()

    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>):HomeScreenState()

}
