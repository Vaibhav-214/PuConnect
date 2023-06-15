package com.example.puconnect.presentation.networkscreen.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.puconnect.mockdata.network.NetworkUserData
import com.example.puconnect.ui.theme.textFieldBorder


@Composable
fun NetworkUserInfo(
    navController: NavHostController,
    networkUserData: NetworkUserData
) {

    Column () {
        Spacer(modifier = Modifier.height(8.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .border(
                    shape = RoundedCornerShape(4.dp),
                    width = (0.25).dp,
                    color = textFieldBorder
                )
                .padding(8.dp)

        ) {

            NetworkUserInfoSec1(networkUserData = networkUserData, navController = navController)

            NetworkUserInfoSec2(networkUserData = networkUserData)

            NetworkUserInfoSec3(networkUserData = networkUserData)

        }

        Spacer(modifier = Modifier.height(8.dp))



    }



}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun NetworkUserInfoPreview() {
   // NetworkUserInfo(networkUserData = netUser1)
}