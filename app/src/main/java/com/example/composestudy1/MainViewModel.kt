package com.example.composestudy1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composestudy1.domain.FeedPost
import com.example.composestudy1.domain.PostComment
import com.example.composestudy1.domain.StatisticItem
import com.example.composestudy1.ui.theme.HomeScreenState

class MainViewModel:ViewModel() {

    private val comments = mutableListOf<PostComment>().apply {
        repeat(10) {
            add(PostComment(id = it))
        }
    }

    private val sourceList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }

    private val initialState = HomeScreenState.Posts(posts = sourceList)

    private var savedState :HomeScreenState= initialState

    private val _screenState = MutableLiveData<HomeScreenState>(initialState)
    val screenState:LiveData<HomeScreenState> = _screenState


    fun closeComments(){
        _screenState.value = savedState
    }
    fun showComments(feedPost: FeedPost){
        _screenState.value = HomeScreenState.Comments(comments = comments, feedPost = feedPost)
    }

    fun updateCount(feedPost: FeedPost, item:StatisticItem){
        val currentState = screenState.value
        if(currentState !is HomeScreenState.Posts) return

        val oldPost = currentState.posts.toMutableList() ?: throw IllegalStateException()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)
        val newPosts = oldPost.apply {
            replaceAll{
                if(it.id == newFeedPost.id){
                    newFeedPost
                }else{
                    it
                }
            }
        }
        _screenState.value = HomeScreenState.Posts(posts = newPosts)
    }


//    fun remove(feedPost: FeedPost) {
//        val oldPosts = screenState.value?.toMutableList() ?: mutableListOf()
//        oldPosts.remove(feedPost)
//        _screenState.value = oldPosts
//    }





}

