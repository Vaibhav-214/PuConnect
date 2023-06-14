package com.example.puconnect.presentation.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.mockdata.home.Guild
import com.example.puconnect.mockdata.home.UserQueData
import com.example.puconnect.mockdata.home.aiGuild
import com.example.puconnect.mockdata.home.designGuild
import com.example.puconnect.mockdata.home.siddhiQue
import com.example.puconnect.presentation.navigation.Destinations
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@Composable
fun UserChatItem(
     userQueData: UserQueData,
     navController: NavHostController
) {
    Column (
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .border(width = (0.25).dp, shape = RoundedCornerShape(4.dp), color = textFieldBorder)

    ){
        UserChatItemSec1(userPhoto = userQueData.userPhoto, userName = userQueData.userName, modifier = Modifier.padding(8.dp))

        Divider(thickness = (0.25).dp, color = textFieldBorder)

        UserChatItemSec2(question = userQueData.question, relatedGuilds = userQueData.guildList)

        Divider(thickness = (0.25).dp, color = textFieldBorder)

        UserChatItemSec3(
            engageCount = userQueData.engageCount,
            onEngageClick = { navController.navigate(Destinations.ChatScreen.createRoute(userQueData.questionId))}
        )
    }

}

@Composable
fun UserChatItemSec1(
    userPhoto: Int,
    userName: String,
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ){
        Image(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape),
            painter = painterResource(id = userPhoto),
            contentDescription = null,
            )
        
        Text(
            modifier = Modifier.padding(8.dp),
            text = userName,
            fontFamily = gilroy,
            fontSize = 12.sp,
            lineHeight = 14.56.sp,
            color = Color.Black
            )
    }

}

@Composable
fun UserChatItemSec2(
    question: String,
    relatedGuilds: List<Guild>
) {
    val screenHeight = LocalConfiguration.current.screenHeightDp

    Column (
        modifier = Modifier
           // .height((screenHeight * 0.18f).dp)
            .padding(8.dp)
    ) {
        Text(
            text = question,
            fontFamily = gilroy,
            fontSize = 14.sp,
            fontWeight = FontWeight.W600,
            lineHeight = 17.15.sp,
            color = Color.Black
        )
        
        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(relatedGuilds) { guild->
                GuildItemChip(iconId = guild.iconId, labelName = guild.guildName)
            }
        }
    }

}

@Composable
fun UserChatItemSec3(
    engageCount: Int,
    onEngageClick: () -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding( 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(48.dp)
            ) {

                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .align(alignment = Alignment.TopEnd),
                    painter = painterResource(id = R.drawable.engage3),
                    contentDescription = null
                )

                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .align(alignment = Alignment.TopCenter),
                    painter = painterResource(id = R.drawable.engage2),
                    contentDescription = null
                )

                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .align(Alignment.TopStart),
                    painter = painterResource(id = R.drawable.engage1),
                    contentDescription = null
                )
            }

            Text(
                modifier = Modifier.padding(8.dp),
                text = "$engageCount Engaging",
                fontFamily = gilroy,
                fontSize = 12.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 14.56.sp,
                color = Color.Black
            )
        }

        Button(
            //modifier = Modifier.wrapContentWidth(),
            onClick = { onEngageClick() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            shape = RoundedCornerShape(4.dp)
            ) {
            Text(
                //modifier = Modifier.padding(8.dp),
                text = "Engage",
                fontFamily = gilroy,
                fontSize = 10.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 12.13.sp,
                color = Color.White
            )
            
            Icon(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(14.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.arrowright),
                contentDescription = null)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuildItemChip(
    iconId: Int,
    labelName: String
) {
    AssistChip(
        modifier = Modifier.height(22.dp),
        shape = RoundedCornerShape(31.dp),
        onClick = { /*TODO*/ },
        label = {
            Text(
                text = labelName,
                color = Color.Black,
                fontFamily = gilroy,
                fontWeight = FontWeight.W500,
                fontSize = 8.sp,
                lineHeight = 9.7.sp
                ) },
        border = AssistChipDefaults.assistChipBorder(
            borderColor = textFieldBorder,
            borderWidth = (0.25).dp
            ),
        leadingIcon = {
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .clip(CircleShape)
                    .background(color = Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(8.dp),
                    imageVector = ImageVector.vectorResource(id = iconId),
                    contentDescription = "code guild",
                    tint = Color.White
                )
            }
        }
        )
}



@Preview(showSystemUi = false, showBackground = true)
@Composable
fun UserChatItemSec1Preview() {
//    UserChatItemSec2(question = "How i can use Chatgpt to code my figma design?",
//        relatedGuilds =listOf<Guild>(
//        aiGuild, designGuild
//    ) )
   // UserChatItemSec3(engageCount = 9)
    
    //UserChatItem(userQueData = siddhiQue)
}