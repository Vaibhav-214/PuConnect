package com.example.puconnect.presentation.messagescreen

import android.hardware.ConsumerIrManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.presentation.homescreen.components.HorizontalSpacer
import com.example.puconnect.ui.theme.gilroy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageScreen(
    navController: NavHostController,
    userName: String,
    userPhoto: Int,
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        TopAppBar(
            title = {
                Text(
                    fontFamily = gilroy,

                    text = userName,
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp,
                    lineHeight = 19.6.sp,
                    color = Color.White
                )
            },
            navigationIcon = {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){

                        Icon(
                            modifier = Modifier
                                .padding(start = 17.dp)
                                .clickable { navController.popBackStack() },
                            imageVector = ImageVector.vectorResource(id = R.drawable.arrowleft),
                            contentDescription = null,
                            tint = Color.White
                        )


                    HorizontalSpacer(width = 16)

                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = userPhoto),
                        contentDescription = null)
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Black)
        )

        BottomChatBox2()

    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun MessageScreenPreview() {
   // MessageScreen(userName = "Jeet Shah", userPhoto = R.drawable.userphoto3)
}