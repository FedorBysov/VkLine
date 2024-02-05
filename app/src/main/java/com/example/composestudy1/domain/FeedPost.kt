package com.example.composestudy1.domain

import com.example.composestudy1.R

data class FeedPost(
    val id: Int = 0,
    val communityName: String = "123",
    val publicationDate: String = "22:22",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "adwadwaadwdawdaw",
    val contentImageResId:Int = R.drawable.post_content_image,
    val statistics:List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, 123),
        StatisticItem(type = StatisticType.COMMENTS, 23),
        StatisticItem(type = StatisticType.SHARES, 13),
        StatisticItem(type = StatisticType.LIKES, 31),

        )
)