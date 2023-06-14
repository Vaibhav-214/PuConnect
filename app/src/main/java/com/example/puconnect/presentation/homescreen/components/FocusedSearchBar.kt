package com.example.puconnect.presentation.homescreen.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puconnect.R
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder
import com.example.puconnect.ui.theme.textFieldPlaceholder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FocusedSearchBar(
    searchText: String,
    onTextChange: (String) -> Unit,
    //onBackClick: () -> Unit,
) {



//    val focusRequester = remember { FocusRequester() }
//    val focusManager = LocalFocusManager.current

//    LaunchedEffect(Unit) {
//        focusRequester.requestFocus()
//        focusManager.moveFocus(FocusDirection.Next)
//    }

//    BackHandler {
//        onBackClick()
//    }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        Icon(
            modifier = Modifier.padding(end = 24.dp),
            imageVector = ImageVector.vectorResource(R.drawable.arrowleft),
            contentDescription = "back button" )


        TextField(
            shape = RoundedCornerShape(4.dp),
            value = searchText,
            onValueChange = { onTextChange(it) },
            modifier = Modifier
                .fillMaxWidth()//0.86f
                .background(color = Color.Transparent)
                .height(48.dp)
                .border(
                    width = (0.25).dp,
                    shape = RoundedCornerShape(4.dp),
                    color = textFieldBorder
                )
                .align(Alignment.CenterVertically)
//                .focusRequester(focusRequester)
//                .onFocusChanged { focusState ->
//                    if (!focusState.isFocused) {
//                        onBackClick()
//                    }
//                }
            ,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedLabelColor = Color.Transparent,
                textColor = Color.Gray,
                placeholderColor = textFieldPlaceholder,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle(
                fontFamily = gilroy,
                fontSize = 12.sp
            ),
            leadingIcon = {
                Icon(
                    modifier = Modifier,
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_search),
                    contentDescription = "Search Icon"
                )
            }
        )




    }
}

@Preview(showSystemUi = true)
@Composable
fun FocusedSearchBarPreview() {
    //FocusedSearchBar()
}