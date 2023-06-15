package com.example.puconnect.presentation.chatscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
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
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.mockdata.chat.msgList
import com.example.puconnect.mockdata.home.UserQueData
import com.example.puconnect.mockdata.home.siddhiQue
import com.example.puconnect.presentation.chatscreen.common.BottomChatBox
import com.example.puconnect.presentation.chatscreen.common.MessageBox
import com.example.puconnect.presentation.chatscreen.common.UserSection
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    queData: UserQueData,
    navController: NavHostController
) {
    Scaffold (
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = siddhiQue.guildList[0].guildName,
                        fontFamily = gilroy,
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp,
                        lineHeight = 19.6.sp,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Black, ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.arrowleft),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomChatBox()
        }
    ){
        Column (
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .fillMaxSize(),

        ){
            UserSection(userQueData = queData, modifier = Modifier.padding(start = 20.dp))

            Divider(modifier = Modifier.fillMaxWidth(), thickness = (0.5).dp, color = textFieldBorder)

            LazyColumn(
                modifier = Modifier
                    .padding(start = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(1.dp))
                }

                items(msgList) {chatMsg->
                    MessageBox(chatMsg = chatMsg)
                }
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ChatScreenPreview() {
   // ChatScreen(queData = siddhiQue,)
}