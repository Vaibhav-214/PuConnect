package com.example.puconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.puconnect.presentation.navigation.RootNavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // for knowing state of keyboard
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
           // AppNavHost()
           // MainScreen()
           // installSplashScreen()
            RootNavigationGraph()
            //WelcomeScreen(navController = rememberNavController())
        }
    }
}

