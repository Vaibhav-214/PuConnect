package com.example.puconnect.presentation.workscreen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
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
import com.example.puconnect.R
import com.example.puconnect.mockdata.work.work1
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@Composable
fun MyApplications(
    illustation: Int = R.drawable.applicationsempty,
    title: String = "No applications found",
    modifier: Modifier = Modifier
) {
        Column (
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            Image(
                modifier = Modifier
                    .width(176.dp)
                    .height(147.dp),
                imageVector = ImageVector.vectorResource(id = illustation),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = title,
                fontFamily = gilroy,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                lineHeight = 16.98.sp,
                color = textFieldBorder
            )

        }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun MyApplicationPreview() {
    MyApplications()
}