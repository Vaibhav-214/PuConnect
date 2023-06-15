package com.example.puconnect.presentation.notificationscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.presentation.workscreen.common.MyApplications
import com.example.puconnect.ui.theme.gilroy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewMessagesScreen(
    navController: NavHostController
) {
    Box (
        modifier = Modifier.fillMaxSize()
    ){
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            title = {
                Text(
                    fontFamily = gilroy,

                    text = "Messages",
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp,
                    lineHeight = 19.6.sp,
                    color = Color.White
                )
            },
            navigationIcon = {
                IconButton(
                    modifier = Modifier.padding(start = 2.dp),
                    onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.arrowleft),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Black)
        )


        MyApplications(
            modifier = Modifier.align(Alignment.Center),
            illustation = R.drawable.nomessages,
            title = "No Conversations Found!"
        )

    }
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
fun NewMessagesScreenPreview() {
   // NewMessagesScreen()
}