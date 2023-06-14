package com.example.puconnect.presentation.chatscreen.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puconnect.mockdata.chat.ChatMsg
import com.example.puconnect.mockdata.chat.msg1
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder


@Composable
fun MessageBox(
    chatMsg: ChatMsg
) {
    val screenwidth = LocalConfiguration.current.screenWidthDp
    Column (
        modifier = Modifier
            .width((screenwidth * 0.753).dp)
            .wrapContentHeight()
            .border(
                width = (0.25).dp,
                color = textFieldBorder,
                shape = RoundedCornerShape(12.dp)
                )
            .padding(vertical = 12.dp, horizontal = 10.dp)
    ){

        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = chatMsg.user,
            fontFamily = gilroy,
            fontWeight = FontWeight.W600,
            fontSize = 14.sp,
            lineHeight = 17.15.sp,
            color = chatMsg.color
        )

        Text(
            text = chatMsg.message,
            fontFamily = gilroy,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            lineHeight = 16.98.sp,
            color = Color.Black
        )

    }

}


@Preview(showSystemUi = true)
@Composable
fun MessageBoxPreview() {
    MessageBox(chatMsg = msg1)
}