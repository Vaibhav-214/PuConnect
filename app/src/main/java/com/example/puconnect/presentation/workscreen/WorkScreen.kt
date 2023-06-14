package com.example.puconnect.presentation.workscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puconnect.mockdata.work.workList
import com.example.puconnect.presentation.common.CustomTopAppBar
import com.example.puconnect.presentation.homescreen.components.FloatingActionButton
import com.example.puconnect.presentation.workscreen.common.MyApplications
import com.example.puconnect.presentation.workscreen.common.WorkPost
import com.example.puconnect.presentation.workscreen.common.WorkSearchSection

@Composable
fun WorkScreen(
    paddingValues: PaddingValues
) {

    var exploreSelected by remember {
        mutableStateOf(true)
    }

    val screenHeight = LocalConfiguration.current.screenHeightDp

    val screenWidth = LocalConfiguration.current.screenWidthDp

    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .padding(horizontal = 20.dp),
        ) {
            CustomTopAppBar(title = "Work")

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
                    .offset(y = -(screenHeight * 0.109f).dp, x = -(screenWidth * 0.051f).dp),
                onClick = {}
            )
        }



    }

}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun WorkScreenPreview() {
    WorkScreen(paddingValues = PaddingValues(bottom = 83.dp))
}