package com.example.puconnect.presentation.common

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.puconnect.R
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.swipeGreen
import com.example.puconnect.ui.theme.textFieldBorder
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeableSample2() {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val width = screenWidth.dp

    val swipeableState = rememberSwipeableState(0)

    val isCompleted = remember {
        mutableStateOf(swipeableState.progress.fraction)
    }

    Log.d("AN","${isCompleted.value}")
    val sizePx = with(LocalDensity.current) { width.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states

    val greenColor = swipeGreen

    val swipeProgress = swipeableState.offset.value / sizePx

    val customModifier = Modifier.swipeable(
        state = swipeableState,
        anchors = anchors,
        thresholds = { _, _ -> FractionalThreshold(0.7f) },
        orientation = Orientation.Horizontal
    )

    val modifier = if (isCompleted.value < 0.99f || isCompleted.value == 1.0f) customModifier else Modifier

    Box(
        modifier = modifier
            .width(width)
            .height(56.dp)

            .apply {
            Modifier.swipeable(
                        state = swipeableState,
                        anchors = anchors,
                        thresholds = { _, _ -> FractionalThreshold(0.7f) },
                        orientation = Orientation.Horizontal
                    )
                 }

            .background(Color.White)
            .let { if (swipeableState.offset.value >= sizePx) it else it.clickable { } }
    ) {
        // Draw the portion before the switch
        Box(
            Modifier
                .height(56.dp)
                .width(swipeProgress * width)
                .background(greenColor)
        )

        Row(
            Modifier
                .fillMaxWidth()
                .height(56.dp)
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier
                    .width(80.dp)
                    .height(56.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.caretdoubleright),
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Text(
                text = "Swipe to Post",
                fontFamily = gilroy,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                lineHeight = 16.8.sp,
            )

            Box(
                Modifier
                    .width(80.dp)
                    .height(56.dp)
                    .background(Color.Transparent),
            )
        }

        // Show "Swipe Completed" when swipe is completed
        if (swipeableState.offset.value >= sizePx) {
            Text(
                text = "Post Successful",
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
                    .background(greenColor)
                    .wrapContentWidth()
                    .wrapContentHeight(),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = gilroy,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                lineHeight = 16.8.sp,
            )
        }
    }
}


@Composable
fun SwipeButton() {
    Row (
        modifier = Modifier
            .padding(start = 20.dp , end = 20.dp , bottom = 20.dp)
            .fillMaxWidth()
            .height(56.dp)
            .border(
                shape = RoundedCornerShape(4.dp),
                width = (0.25).dp,
                color = textFieldBorder
            )
            .clip(RoundedCornerShape(4.dp))

    ) {

    SwipeableSample2()

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PReview() {
    SwipeButton()
}

