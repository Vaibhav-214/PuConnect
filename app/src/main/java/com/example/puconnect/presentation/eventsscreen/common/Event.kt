package com.example.puconnect.presentation.eventsscreen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import com.example.puconnect.R
import com.example.puconnect.presentation.eventsscreen.EventsScreen
import com.example.puconnect.presentation.homescreen.components.HorizontalSpacer
import com.example.puconnect.presentation.networkscreen.common.CustomButton2
import com.example.puconnect.ui.theme.chatGptcolor
import com.example.puconnect.ui.theme.gilroy

@Composable
fun Event() {

    Column (
        modifier = Modifier.fillMaxWidth().height(291.dp),
        verticalArrangement = Arrangement.Center
    ) {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(275.dp)
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(4.dp),
                )


        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.TopStart)
                    .padding(start = 16.dp, bottom = 16.dp, top = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    //  modifier = Modifier.fillMaxHeight()
                ) {


                    Text(
                        text = "The ultimate",
                        fontFamily = gilroy,
                        fontWeight = FontWeight.W600,
                        fontSize = 27.14.sp,
                        lineHeight = 28.1.sp,
                        color = Color.White
                    )

                    Text(
                        text = "CHATGPT",
                        fontFamily = gilroy,
                        fontWeight = FontWeight.W800,
                        fontSize = 27.14.sp,
                        lineHeight = 28.1.sp,
                        color = chatGptcolor
                    )

                    Text(
                        text = "Prompt training",
                        fontFamily = gilroy,
                        fontWeight = FontWeight.W600,
                        fontSize = 27.14.sp,
                        lineHeight = 28.1.sp,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.calendarblank),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )

                        HorizontalSpacer(width = 8)

                        Text(
                            text = "Friday, June 09",
                            fontFamily = gilroy,
                            fontWeight = FontWeight.W500,
                            fontSize = 12.sp,
                            lineHeight = 12.42.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.clock),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )

                        HorizontalSpacer(width = 8)


                        Text(
                            text = "7:30 PM",
                            fontFamily = gilroy,
                            fontWeight = FontWeight.W500,
                            fontSize = 12.sp,
                            lineHeight = 12.42.sp,
                            color = Color.White
                        )
                    }
                }


                CustomButton2(
                    onClick = { /*TODO*/ },
                    title = "Enroll Now",
                    icon = R.drawable.arrowright,
                    contentColor = Color.Black,
                    buttonColor = Color.White
                )
            }

            Image(
                modifier = Modifier
                    .height(260.dp)
                    .width(288.dp)
                    .clip(RoundedCornerShape(bottomEnd = 4.dp))
                    .align(Alignment.BottomEnd)
                    .offset(x = 36.dp),
                painter = painterResource(id = R.drawable.adphoto),
                contentDescription = null
            )


        }
    }
}

@Preview(showBackground = true)
@Composable
fun Eventpreview() {
   // EventsScreen()
}