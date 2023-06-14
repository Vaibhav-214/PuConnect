package com.example.puconnect.presentation.homescreen.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager

@Composable
fun SearchBar() {
    var searchText by remember {
        mutableStateOf("")
    }

//    var isSearchBarClicked by remember {
//        mutableStateOf(false)
//    }


    if (searchText != "") {
        FocusedSearchBar(
            searchText = searchText,
            onTextChange = { searchText = it },
//            onBackClick = {
//                isSearchBarClicked = false
//            },
            )
    } else {
        UnfocusedSearchBar(
            searchText = searchText,
            onTextChange = { searchText = it },
           // onClick = {isSearchBarClicked = true},
            )

    }
}