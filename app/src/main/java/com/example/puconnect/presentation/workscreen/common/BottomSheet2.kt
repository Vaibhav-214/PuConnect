package com.example.puconnect.presentation.workscreen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puconnect.R
import com.example.puconnect.presentation.homescreen.components.HorizontalSpacer
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder
import eu.wewox.modalsheet.ExperimentalSheetApi
import eu.wewox.modalsheet.ModalSheet

/**
 * Showcases the most simple usage of the modal sheet composable.
 * Shows the bottom sheet on button click.
 */
@Composable
fun SimpleModalSheetScreen() {
    Scaffold(
        topBar = {
            TopAppBar {
                Text(text = "Top bat")
            }

        }
    ) { padding ->
        var visible by rememberSaveable { mutableStateOf(false) }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Button(onClick = { visible = true }) {
                Text(text = "Show modal sheet")
            }
        }

        SimpleModalSheet(
            visible = visible,
            onVisibleChange = { visible = it }
        )
    }
}

/**
 * Simple [ModalSheet] example which contains only texts and button to close bottom sheet.
 *
 * @param title The title to show inside [ModalSheet].
 * @param visible True if modal should be visible.
 * @param onVisibleChange Called when visibility changes.
 */
@OptIn(ExperimentalSheetApi::class)
@Composable
fun SimpleModalSheet(
    visible: Boolean,
    onVisibleChange: (Boolean) -> Unit,
) {
    ModalSheet(
        visible = visible,
        onVisibleChange = onVisibleChange,
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(465.dp)
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    )
                .navigationBarsPadding()
        ) {
            Spacer(modifier = Modifier.height(8.dp))



            Box (
                modifier = Modifier.height(4.dp).width(58.dp).background(color = Color(0xffD9D9D9))
            )

            Spacer(modifier = Modifier.height(18.dp))



            Image(
                contentScale = ContentScale.Fit,
                imageVector = ImageVector.vectorResource(
                    id = R.drawable.group
                ), contentDescription = null
            )
            Divider(
                Modifier
                    .height(1.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            androidx.compose.material3.Text(
                text = "Be a Recruiter!",
                fontFamily = gilroy,
                fontWeight = FontWeight.W600,
                fontSize = 24.sp,
                lineHeight = 29.4.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            androidx.compose.material3.Text(
                text = "To post a gig, you'll first need to add some more info\n" +
                        "about you or your company. This will help ensure your\n" +
                        "listing is not a spam or inappropriate.",
                fontFamily = gilroy,
                fontWeight = FontWeight.W600,
                fontSize = 12.sp,
                lineHeight = 14.7.sp,
                color = textFieldBorder,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            androidx.compose.material3.Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(4.dp),
                onClick = { /*TODO*/ }) {
                androidx.compose.material3.Text(
                    text = "Add recruiter info",
                    fontFamily = gilroy,
                    fontWeight = FontWeight.W600,
                    fontSize = 14.sp,
                    lineHeight = 17.5.sp,
                    color = Color.White
                )

                HorizontalSpacer(width = 8)

                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.arrowright),
                    contentDescription = null,
                    tint = Color.White
                )

            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BottomSheet2Preview() {
    SimpleModalSheetScreen()
}