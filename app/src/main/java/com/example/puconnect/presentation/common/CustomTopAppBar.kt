package com.example.puconnect.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puconnect.R
import com.example.puconnect.presentation.homescreen.components.HorizontalSpacer
import com.example.puconnect.ui.theme.gilroy

@Composable
fun CustomTopAppBar(
    title: String,
    onShareClick: () -> Unit = {},
    onBellClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(78.dp),
            //.padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontFamily = gilroy,
            fontWeight = FontWeight.W600,
            fontSize = 20.sp,
            lineHeight = 24.5.sp,
            color = Color.Black
        )

        Row (
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Icon(
                modifier = Modifier.clickable { onBellClick() },
                imageVector = ImageVector.vectorResource(id = R.drawable.bellsimple),
                contentDescription = null
            )

            HorizontalSpacer(width = 24)


            Icon(
                modifier = Modifier.clickable { onShareClick() },
                imageVector = ImageVector.vectorResource(id = R.drawable.paperplanetilt),
                contentDescription = null
            )
        }

    }
}