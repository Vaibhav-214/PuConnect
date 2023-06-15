package com.example.puconnect.presentation.homescreen.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.input.key.Key.Companion.U
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun SearchBar(
    navController: NavHostController
) {
    var searchText by remember {
        mutableStateOf("")
    }

    UnfocusedSearchBar(
        navController = navController,
        searchText = searchText,
        onTextChange = { searchText = it },
    )
}