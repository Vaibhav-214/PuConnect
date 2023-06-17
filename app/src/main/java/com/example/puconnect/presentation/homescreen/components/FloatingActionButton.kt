package com.example.puconnect.presentation.homescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.puconnect.R

@Composable
fun FloatingActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp
   Box (
       modifier = modifier
           .size((screenWidth * 0.184f).dp)
           .clip(CircleShape)
           .clickable { onClick() }
           .background(color = Color.Black)
           .dashedBorder(width = 1.dp, radius = (screenWidth*0.0923f).dp, color = Color.White),
       contentAlignment = Alignment.Center
   ){

       Icon(
           modifier = Modifier.size((screenWidth*0.082f).dp),
           imageVector = ImageVector.vectorResource(id = R.drawable.plus__1_),
           contentDescription = null,
           tint = Color.White
       )

   }
}

fun Modifier.dashedBorder(width: Dp, radius: Dp, color: Color) =
    drawBehind {
        drawIntoCanvas {
            val paint = Paint()
                .apply {
                    strokeWidth = width.toPx()
                    this.color = color
                    style = PaintingStyle.Stroke
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                }
            it.drawRoundRect(
                width.toPx(),
                width.toPx(),
                size.width - width.toPx(),
                size.height - width.toPx(),
                radius.toPx(),
                radius.toPx(),
                paint
            )
        }
    }

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun FloatingActionButtonPreview() {
    FloatingActionButton()
}