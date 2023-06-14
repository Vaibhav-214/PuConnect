package com.example.puconnect.presentation.guildscreen.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.mockdata.home.UserQueData
import com.example.puconnect.mockdata.home.codeGuildQueList
import com.example.puconnect.presentation.homescreen.components.UserChatItem
import com.example.puconnect.ui.theme.gilroy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuildScreen(
    guildName: String,
    guildList: List<UserQueData>,
    navController: NavHostController
) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = guildName,
                    fontFamily = gilroy,
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp,
                    lineHeight = 19.6.sp,
                    color = Color.White
                )
            },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Black, ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.arrowleft),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            )
        },
        
        
    ){it
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(1.dp))
            }

            items(guildList) {userQueData ->
                UserChatItem(userQueData = userQueData, navController = navController)
            }
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GuildScreenPreview() {
    //GuildScreen(guildName = "Coding Guild", guildList = codeGuildQueList, onClick = {})
}