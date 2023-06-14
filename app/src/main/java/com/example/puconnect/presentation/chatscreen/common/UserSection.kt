package com.example.puconnect.presentation.chatscreen.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puconnect.mockdata.home.UserQueData
import com.example.puconnect.mockdata.home.siddhiQue
import com.example.puconnect.presentation.homescreen.components.UserChatItemSec1
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@Composable
fun UserSection(
    userQueData: UserQueData,
    modifier: Modifier = Modifier
) {

    val screenHeight = LocalConfiguration.current.screenHeightDp
    val screenWidth = LocalConfiguration.current.screenWidthDp
    Column (
        modifier = modifier.width((screenWidth*0.812f).dp)
    ) {

       // Spacer(modifier = Modifier.height((screenHeight*0.019).dp))
        Spacer(modifier = Modifier.height(16.dp))

        UserChatItemSec1(userPhoto = userQueData.userPhoto, userName = userQueData.userName)

        //Spacer(modifier = Modifier.height((screenHeight*0.019).dp))
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = userQueData.question,
            fontFamily = gilroy,
            fontWeight = FontWeight.W600,
            fontSize = 20.sp,
            lineHeight = 24.5.sp,
            color = Color.Black
        )

        //Spacer(modifier = Modifier.height((screenHeight*0.028).dp))
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = userQueData.queDetails,
            fontFamily = gilroy,
            fontWeight = FontWeight.W500,
            fontSize = 12.sp,
            lineHeight = 14.56.sp,
            color = textFieldBorder
        )

        //Spacer(modifier = Modifier.height((screenHeight*0.028).dp))
        Spacer(modifier = Modifier.height(24.dp))


    }

}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun UserSectionPreview() {
    UserSection(userQueData = siddhiQue)
}