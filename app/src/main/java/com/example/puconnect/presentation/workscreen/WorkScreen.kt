package com.example.puconnect.presentation.workscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.puconnect.mockdata.work.workList
import com.example.puconnect.presentation.common.CustomTopAppBar
import com.example.puconnect.presentation.homescreen.components.FloatingActionButton
import com.example.puconnect.presentation.navigation.Destinations
import com.example.puconnect.presentation.workscreen.common.MyApplications
import com.example.puconnect.presentation.workscreen.common.SimpleModalSheet
import com.example.puconnect.presentation.workscreen.common.WorkPost
import com.example.puconnect.presentation.workscreen.common.WorkSearchSection

@Composable
fun WorkScreen(
    navController: NavHostController,
    paddingValues: PaddingValues
) {

    var exploreSelected by remember {
        mutableStateOf(true)
    }

    var bottomSheetVisible by rememberSaveable { mutableStateOf(false) }

    val screenHeight = LocalConfiguration.current.screenHeightDp

    val screenWidth = LocalConfiguration.current.screenWidthDp

    SimpleModalSheet(visible = bottomSheetVisible, onVisibleChange = { bottomSheetVisible = it})

    Box (
        modifier = Modifier
            .fillMaxSize()
            //.navigationBarsPadding()
    ) {
        Column (
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .padding(horizontal = 20.dp),
        ) {
            CustomTopAppBar(
                title = "Work",
                onShareClick = {navController.navigate(Destinations.NewMessageScreen.route)},
                onBellClick = {navController.navigate(Destinations.NotificationScreen.route)}
                )

            WorkSearchSection(
                onExploreClick = {exploreSelected = true},
                onMyApplicationClick = {exploreSelected = false},
                exploreSelected = exploreSelected
            )

            if (exploreSelected) {
                LazyColumn() {
                    items(workList) { work ->
                        WorkPost(workPostData = work)
                    }
                }
            } else {
                MyApplications()
            }
        }

        if (exploreSelected) {
            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(y = -(screenHeight * 0.135f).dp, x = -(20).dp),
                onClick = {bottomSheetVisible = true}
            )
        }



    }

}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun WorkScreenPreview() {
  //  WorkScreen(paddingValues = PaddingValues(bottom = 83.dp))
}