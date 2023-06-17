package com.example.puconnect.presentation.workscreen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.mockdata.work.workList
import com.example.puconnect.presentation.common.CustomTopAppBar
import com.example.puconnect.presentation.homescreen.components.FloatingActionButton
import com.example.puconnect.presentation.homescreen.components.HorizontalSpacer
import com.example.puconnect.presentation.navigation.Destinations
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewBottomSheet(
    //navController: NavHostController,
    paddingValues: PaddingValues
) {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    var exploreSelected by remember {
        mutableStateOf(true)
    }

    val screenHeight = LocalConfiguration.current.screenHeightDp

    val screenWidth = LocalConfiguration.current.screenWidthDp



    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
        sheetState = sheetState,
        sheetBackgroundColor = Color.White,
        sheetContent = {

            Column(
                Modifier
                    .fillMaxWidth()
                    .height(480.dp)
                    .background(color = Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(8.dp))



                Box (
                    modifier = Modifier.height(4.dp).width(58.dp).background(color = Color(0xffD9D9D9))
                )

                Spacer(modifier = Modifier.height(18.dp))



                Image(
                    contentScale = ContentScale.Fit,
                    imageVector = ImageVector.vectorResource(
                        id = R.drawable.group
                    ), contentDescription = null
                )
                Divider(
                    Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Be a Recruiter!",
                    fontFamily = gilroy,
                    fontWeight = FontWeight.W600,
                    fontSize = 24.sp,
                    lineHeight = 29.4.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "To post a gig, you'll first need to add some more info\n" +
                            "about you or your company. This will help ensure your\n" +
                            "listing is not a spam or inappropriate.",
                    fontFamily = gilroy,
                    fontWeight = FontWeight.W600,
                    fontSize = 12.sp,
                    lineHeight = 14.7.sp,
                    color = textFieldBorder
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(4.dp),
                    onClick = { /*TODO*/ }) {
                    Text(
                        text = "Add recruiter info",
                        fontFamily = gilroy,
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        lineHeight = 17.5.sp,
                        color = Color.White
                    )

                    HorizontalSpacer(width = 8)

                    Icon(
                        modifier = Modifier.size(16.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.arrowright),
                        contentDescription = null,
                        tint = Color.White
                    )

                }


            }
        }
    ) {
        Box(
            Modifier
                .fillMaxSize(),
                //.padding(innerPadding),
            contentAlignment = Alignment.BottomCenter
        ) {



            Box (
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column (
                    modifier = Modifier
                        .padding(paddingValues = paddingValues)
                        .padding(horizontal = 20.dp),
                ) {
                    CustomTopAppBar(
                        title = "Work",
                        onShareClick = {
                           // navController.navigate(Destinations.NewMessageScreen.route)
                        },
                        onBellClick = {
                           // navController.navigate(Destinations.NotificationScreen.route)
                        }
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
                            .offset(y = -(screenHeight * 0.135f).dp, x = -(screenWidth * 0.051f).dp),
                        onClick = { scope.launch { sheetState.show() }}
                    )
                }
            }

        }


    }
}