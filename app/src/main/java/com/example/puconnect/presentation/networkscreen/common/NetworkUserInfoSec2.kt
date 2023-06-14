package com.example.puconnect.presentation.networkscreen.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puconnect.mockdata.network.NetworkUserData
import com.example.puconnect.mockdata.network.netUser1
import com.example.puconnect.ui.theme.addressColor
import com.example.puconnect.ui.theme.gilroy

@Composable
fun NetworkUserInfoSec2(
    networkUserData: NetworkUserData
) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = networkUserData.role,
            fontFamily = gilroy,
            fontWeight = FontWeight.W500,
            fontSize = 12.sp,
            lineHeight = 14.56.sp,
            color = addressColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Talk to me about",
            fontFamily = gilroy,
            fontWeight = FontWeight.W600,
            fontSize = 12.sp,
            lineHeight = 14.7.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}




@Preview(showSystemUi = false, showBackground = true)
@Composable
fun NetworkUserInfo2Preview() {
    NetworkUserInfoSec2(networkUserData = netUser1)
}