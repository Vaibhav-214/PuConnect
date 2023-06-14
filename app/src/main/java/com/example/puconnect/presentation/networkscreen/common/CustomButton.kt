package com.example.puconnect.presentation.networkscreen.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import com.example.puconnect.ui.theme.addressColor
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
)  {
    Button(
        modifier = modifier
            .height(44.dp)
            .background(
                shape = RoundedCornerShape(4.dp),
                color = Color.Black
            ),
        contentPadding = PaddingValues(vertical = 0.dp ,horizontal = 12.dp),

        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        onClick = { onClick() }
    ) {

        Text(
            text = title,
            fontFamily = gilroy,
            fontWeight = FontWeight.W500,
            fontSize = 12.sp,
            lineHeight = 14.56.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            modifier = Modifier
                .height(5.74.dp)
                .width(10.73.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.vector),
            contentDescription = null,
            tint = Color.White
            )

    }
}

@Composable
fun CustomButton2(
    onClick: () -> Unit,
    title: String,
) {

    Box (
        modifier = Modifier
            .height(36.dp)
            .width(94.dp)
            .background(
                shape = RoundedCornerShape(4.dp),
                color = Color.Black
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = title,
                fontFamily = gilroy,
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                lineHeight = 14.56.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                modifier = Modifier.size(12.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.paperplanetilt),
                contentDescription = null,
                tint = Color.White
                )
        }
    }

}

@Composable
fun CustomButton3(
    exploreSelected : Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    title: String,
) {

    Box (
        modifier = modifier
            .height(44.dp)
            .border(
                shape = RoundedCornerShape(4.dp),
                width = (0.25).dp,
                color = if (exploreSelected) Color.Black else textFieldBorder
            )
            .background(
                shape = RoundedCornerShape(4.dp),
                color = if (exploreSelected) Color.Black else Color.White
            )

            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
            Text(
                text = title,
                fontFamily = gilroy,
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                lineHeight = 14.56.sp,
                color = if (exploreSelected) Color.White else addressColor
            )
    }

}

@Preview(showBackground = true)
@Composable
fun CustomButtonpreview() {
    CustomButton3(exploreSelected = true, onClick = { /*TODO*/ }, title = "Explore")
}