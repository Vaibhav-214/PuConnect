package com.example.puconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.puconnect.presentation.navigation.AppNavHost
import com.example.puconnect.presentation.navigation.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // AppNavHost()
            MainScreen()
        }
    }
}

