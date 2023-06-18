package com.example.puconnect.presentation.homescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.mockdata.home.guildList
import com.example.puconnect.presentation.navigation.Destinations
import com.example.puconnect.ui.theme.gilroy


@Composable
fun GuildScrollableRow(
    navController: NavHostController
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp


    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
//        item {
//            Spacer(modifier = Modifier.width(1.dp))
//        }

        items(guildList) {guild->
            GuildItem(
                iconId = guild.iconId,
                guildName = guild.guildName,
                onClick = {navController.navigate(guild.destination.route)} )
        }
    }
}

@Composable
fun GuildItem(
    iconId: Int,
    guildName: String,
    onClick: () -> Unit,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        HorizontalSpacer(width = 20)

    Box(
        modifier = Modifier
            .width(73.dp)

            .height(75.dp)
    ) {


        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(56.dp)
                .clip(CircleShape)
                .background(color = Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(32.dp)
                    .clickable { onClick() },
                imageVector = ImageVector.vectorResource(id = iconId),
                contentDescription = "code guild",
                tint = Color.White
            )
        }

        Text(
            modifier = Modifier.align(Alignment.BottomCenter),
            text = guildName,
            fontFamily = gilroy,
            fontSize = 12.sp,
            lineHeight = 12.13.sp,
            color = Color.Black
        )
    }
        HorizontalSpacer(width = 4)

}

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GuildScrollableRowPreview() {
   // GuildScrollableRow()
}