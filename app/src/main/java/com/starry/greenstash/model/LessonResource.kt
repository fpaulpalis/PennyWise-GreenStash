package com.starry.greenstash.model

import androidx.annotation.DrawableRes

data class LessonResource(
    val id: Int,
    val title: String,
    @DrawableRes val imageRes: Int,
    val desc: String,
    val url: String
)