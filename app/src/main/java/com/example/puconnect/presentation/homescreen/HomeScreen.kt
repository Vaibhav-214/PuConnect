package com.example.puconnect.presentation.homescreen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.puconnect.mockdata.home.UserQueData
import com.example.puconnect.mockdata.home.userQueList
import com.example.puconnect.presentation.homescreen.components.BottomNavigationBar
import com.example.puconnect.presentation.homescreen.components.FloatingActionButton
import com.example.puconnect.presentation.homescreen.components.GuildScrollableRow
import com.example.puconnect.presentation.homescreen.components.SearchBar
import com.example.puconnect.presentation.homescreen.components.UserChatItem
import com.example.puconnect.presentation.navigation.Destinations
import com.example.puconnect.ui.theme.gilroy
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    padding: PaddingValues
   // bottomNavigationBar: @Composable () -> Unit,
) {

    
    val screenHeight = LocalConfiguration.current.screenHeightDp

    val screenWidth = LocalConfiguration.current.screenWidthDp



        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {


            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)

            ) {
                Spacer(modifier = Modifier.height((screenHeight * 0.015f).dp))

                SearchBar(navController = navController)

                Spacer(modifier = Modifier.height((screenHeight * 0.015f).dp))

                Text(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = "Guilds",
                    fontFamily = gilroy,
                    fontWeight = FontWeight.W600,
                    fontSize = 14.sp,
                    lineHeight = 17.15.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height((screenHeight * 0.02f).dp))

                GuildScrollableRow(navController = navController)

                Spacer(modifier = Modifier.height((screenHeight * 0.04f).dp))

                Text(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = "Chats",
                    fontFamily = gilroy,
                    fontWeight = FontWeight.W600,
                    fontSize = 14.sp,
                    lineHeight = 17.15.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height((screenHeight * 0.02f).dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                    // .height((screenHeight*0.6f).dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    items(userQueList) { item ->
                        UserChatItem(userQueData = item, navController)
                    }
                }
            }

            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(y = -(113).dp, x = -(20).dp),
                onClick = {
                    navController.navigate(Destinations.NewDiscussionScreen.route)
                }
            )


        }


}


@OptIn(ExperimentalAnimationApi::class)
@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    //HomeScreen(navController = rememberAnimatedNavController())
}