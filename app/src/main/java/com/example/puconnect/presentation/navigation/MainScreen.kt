package com.example.puconnect.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController =  rememberAnimatedNavController()

    Scaffold (
        containerColor = Color.White,
        bottomBar = { BottomBar(navController = navController)}
    ){
        BottomNavGraph(
            navController = navController,
            padding = it
            )
    }
}