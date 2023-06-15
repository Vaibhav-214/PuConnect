package com.example.puconnect.presentation.welcomescreen

import android.window.SplashScreen
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.presentation.navigation.Graphs
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavHostController)  {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Graphs.AUTH)
    }
    SplashScreen(alpha = alphaAnim.value)
}






@Composable
fun SplashScreen(
    alpha: Float
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            modifier = Modifier
                .width(104.dp)
                .height(58.dp)
                .align(Alignment.Center)
                .alpha(alpha),
            imageVector = ImageVector.vectorResource(id = R.drawable.puconnect),
            contentDescription = null
        )

    }
}