package com.example.puconnect.presentation.welcomescreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.presentation.homescreen.components.HorizontalSpacer
import com.example.puconnect.presentation.navigation.Graphs
import com.example.puconnect.ui.theme.addressColor
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@Composable
fun WelcomeScreen(
    navController: NavHostController
) {

    Log.d("TEST", "works fine")
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(338.dp)
                    .padding(top = 16.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(241.dp)
                        .align(Alignment.TopCenter),
                    painter = painterResource(id = R.drawable.parulimage),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )

                Image(
                    modifier = Modifier
                        .width(177.dp)
                        .height(154.dp)
                        .align(Alignment.BottomCenter),
                    imageVector = ImageVector.vectorResource(id = R.drawable.people),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                fontFamily = gilroy,

                text = "Connect. Grow. Thrive.",
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
                lineHeight = 24.26.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                fontFamily = gilroy,

                text = "Connect, collaborate, ignite potential. \n  Empowering students for academic \n and personal growth journey.",
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                lineHeight = 14.56.sp,
                color = Color(0xff8F8F8F)
            )
        }




        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 20.dp)
        ) {

            Button(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        shape = RoundedCornerShape(4.dp),
                        color = Color.Black
                    ),
                onClick = { navController.navigate(Graphs.MAIN) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {

                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.googleimage),
                    contentDescription = null
                )

                HorizontalSpacer(width = 16)

                Text(
                    fontFamily = gilroy,

                    text = "Continue with Google",
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                    lineHeight = 16.98.sp,
                    color = Color.White
                )

            }

            Spacer(modifier = Modifier.height(9.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier.weight(0.5f),
                    color = addressColor,
                    thickness = (0.25).dp
                )

                Text(
                    fontFamily = gilroy,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "or",
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                    lineHeight = 16.98.sp,
                    color = addressColor
                )

                Divider(
                    modifier = Modifier.weight(0.5f),
                    color = addressColor,
                    thickness = (0.25).dp
                )

            }

            Spacer(modifier = Modifier.height(9.dp))

            Button(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .border(
                        shape = RoundedCornerShape(4.dp),
                        color = textFieldBorder,
                        width = (0.25).dp
                    )
                    .background(
                        shape = RoundedCornerShape(4.dp),
                        color = Color.White
                    ),
                onClick = { navController.navigate(Graphs.MAIN) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {

                Text(
                    fontFamily = gilroy,
                    text = "Continue with Email",
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                    lineHeight = 16.98.sp,
                    color = Color.Black
                )

            }

            Spacer(modifier = Modifier.height(40.dp))


        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    //WelcomeScreen()
}