package com.example.composestudy1.domain

data class StatisticItem(
    val type:StatisticType,
    val count: Int = 0
)

enum class StatisticType{
    VIEWS, COMMENTS, SHARES, LIKES
}

