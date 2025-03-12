package com.starry.greenstash.ui.screens.learn.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.starry.greenstash.model.LessonResource

@Composable
fun LessonResourceCardList(lessons: List<LessonResource>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(lessons) { lesson ->
            LessonResourceCard(lesson = lesson)
        }
    }
}
