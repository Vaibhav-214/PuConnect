package com.example.puconnect.presentation.messagescreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puconnect.R
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomChatBox2() {

    val screenWidth = LocalConfiguration.current.screenWidthDp
    var typedMsg by remember {
        mutableStateOf("")
    }

    BottomAppBar (
        containerColor = Color.Transparent
    ){

        Spacer(modifier = Modifier.width(20.dp))



        TextField(
            value = typedMsg,
            onValueChange = {typedMsg = it},
            modifier = Modifier
                .width((screenWidth * 0.77f).dp)
                .height(56.dp)
                .border(
                    width = (0.25).dp,
                    color = textFieldBorder,
                    shape = RoundedCornerShape(4.dp)
                )
            ,
            placeholder = {
                Text(
                    text = "Type your message here...",
                    fontFamily = gilroy,
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 16.8.sp,
                    color = textFieldBorder,
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedLabelColor = Color.Transparent,
                textColor = Color.Black,
                placeholderColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.paperclip), contentDescription = null)
            }
        )
        Spacer(modifier = Modifier.width((screenWidth*0.061).dp))

        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.paperplanetilt), contentDescription = null)
    }

}