/**
 * MIT License
 *
 * Copyright (c) [2022 - Present] Stɑrry Shivɑm
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


package com.starry.greenstash.ui.screens.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.starry.greenstash.R
import com.starry.greenstash.ui.navigation.DrawerScreens
import com.starry.greenstash.ui.screens.settings.ThemeMode
import com.starry.greenstash.ui.theme.greenstashFont
import com.starry.greenstash.utils.weakHapticFeedback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun HomeDrawer(drawerState: DrawerState, navController: NavController, themeMode: ThemeMode) {
    LocalContext.current

    val items = DrawerScreens.getAllItems()
    val selectedItem = remember { mutableStateOf(items[0]) }
    val coroutineScope = rememberCoroutineScope()

    ModalDrawerSheet(
        modifier = Modifier.width(295.dp),
        drawerShape = RoundedCornerShape(topEnd = 14.dp, bottomEnd = 14.dp),
        drawerTonalElevation = 2.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            DrawerHeader(themeMode)

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                thickness = 0.5.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
            )

            DrawerItems(items, selectedItem, drawerState, navController, coroutineScope)

        }
    }
}


@Composable
private fun DrawerHeader(themeMode: ThemeMode) {
    Row(
        modifier = Modifier
            .height(140.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        // Logo or image
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(
                    color = if (themeMode == ThemeMode.Light) MaterialTheme.colorScheme.onSurface
                    else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.15f),
                    shape = CircleShape
                )
        ) {
            AsyncImage(
                model = R.drawable.ic_launcher_foreground,
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier.fillMaxSize(),
            )
        }
        Spacer(modifier = Modifier.width(18.dp))
        // App name
        Text(
            text = stringResource(id = R.string.app_name),
            fontFamily = greenstashFont,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun DrawerItems(
    items: List<DrawerScreens>,
    selectedItem: MutableState<DrawerScreens>,
    drawerState: DrawerState,
    navController: NavController,
    coroutineScope: CoroutineScope
) {
    val view = LocalView.current
    items.forEach { item ->
        NavigationDrawerItem(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = item.iconResId),
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(id = item.nameResId), fontFamily = greenstashFont
                )
            },
            selected = item == selectedItem.value,
            onClick = {
                view.weakHapticFeedback()
                coroutineScope.launch {
                    drawerState.close()
                    if (item != selectedItem.value) {
                        withContext(Dispatchers.Main) {
                            navController.navigate(item)
                        }
                    }
                    selectedItem.value = item
                }
            },
            modifier = Modifier
                .width(280.dp)
                .padding(NavigationDrawerItemDefaults.ItemPadding)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}


@Preview
@Composable
private fun HomeDrawerPV() {
    HomeDrawer(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
        navController = rememberNavController(),
        themeMode = ThemeMode.Light
    )
}