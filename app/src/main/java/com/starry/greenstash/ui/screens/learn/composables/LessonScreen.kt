package com.starry.greenstash.ui.screens.learn.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.starry.greenstash.R
import com.starry.greenstash.model.LessonResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonScreen(navController: NavController) {

    val lessons = listOf(
        LessonResource(
            1,
            "What is Financial Literacy?",
            R.drawable.lesson1,
            "This topic introduces the fundamentals of financial literacy and why it is essential for making informed financial decisions.",
            "https://www.investopedia.com/terms/f/financial-literacy.asp"

        ),
        LessonResource(
            2,
            "Budgeting Basics",
            R.drawable.lesson2,
            "Budgeting helps manage income and expenses effectively to achieve financial goals.",
            "https://dfr.oregon.gov/financial/manage/pages/budget.aspx"
        ),
        LessonResource(
            3,
            "Saving Strategies",
            R.drawable.lesson3,
            "This topic focuses on the importance of saving and different strategies to achieve financial security.",
            "https://bettermoneyhabits.bankofamerica.com/en/saving-budgeting/ways-to-save-money"
        ),
        LessonResource(
            4,
            "Managing Debt",
            R.drawable.lesson4,
            "Understanding debt and repayment strategies can help maintain financial stability.",
            "https://www.investopedia.com/articles/pf/12/good-debt-bad-debt.asp"
        ),
        LessonResource(
            5,
            "Investing Fundamentals",
            R.drawable.lesson5,
            "Investing is key to growing wealth over time. This topic introduces basic investment principles.",
            "https://www.investopedia.com/articles/basics/11/3-s-simple-investing.asp"
        ),
        LessonResource(
            6,
            "Understanding Credit",
            R.drawable.lesson6,
            "Credit plays a crucial role in financial health, affecting loans, interest rates, and financial opportunities.",
            "https://consumer.ftc.gov/articles/understanding-your-credit"
        ),
        LessonResource(
            7,
            "Financial Scams and Protection",
            R.drawable.lesson7,
            "Financial fraud is a growing concern, and knowing how to protect yourself is essential.",
            "https://www.uwcu.org/online-banking/articles/10-scams"        )
    )

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = "Lesson List",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        if (isLandscape) {
            // 2x2 Grid in Landscape Mode
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(8.dp)
            ) {
                items(lessons) { lesson ->
                    LessonResourceCard(lesson)
                }
            }
        } else {
            // Single-column list in Portrait Mode
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(8.dp)
            ) {
                items(lessons) { lesson ->
                    LessonResourceCard(lesson)
                }
            }
        }
    }
}

