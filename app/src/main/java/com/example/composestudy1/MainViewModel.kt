package com.example.composestudy1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composestudy1.domain.FeedPost
import com.example.composestudy1.domain.StatisticItem

class MainViewModel:ViewModel() {

    private val _feedPost = MutableLiveData<FeedPost>(FeedPost())
    val feedPost:LiveData<FeedPost> = _feedPost

    fun updateCount(item:StatisticItem){
        val oldStatistics = feedPost.value?.statistics ?: throw IllegalStateException()
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        _feedPost.value = _feedPost.value?.copy(statistics = newStatistics)
    }








}

