package com.example.composestudy1.domain

import com.example.composestudy1.R

data class PostComment(
    val id:Int,
    val authorName:String="author",
    val authorAvatarId:Int = R.drawable.ic_launcher_foreground,
    val commentText:String = "Long Comment Text",
    val publicationDate:String ="12:12"
)
