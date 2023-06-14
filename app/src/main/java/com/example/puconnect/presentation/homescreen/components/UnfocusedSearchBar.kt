package com.example.puconnect.presentation.homescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
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
fun UnfocusedSearchBar(
    searchText: String,
    onTextChange: (String) -> Unit,
   // onClick: () -> Unit,
) {

//    val focusRequester = remember { FocusRequester() }
//
//    DisposableEffect(Unit) {
//        onDispose {
//            focusRequester.requestFocus()
//        }
//    }
    Row(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            shape = RoundedCornerShape(4.dp),
            value = searchText,
            onValueChange = { onTextChange(it) },
            modifier = Modifier
                .fillMaxWidth(0.72f)//0.72f
                .background(color = Color.Transparent)
               // .clickable { onClick() }
                .height(48.dp)
                .border(
                    width = (0.25).dp,
                    shape = RoundedCornerShape(4.dp),
                    color = textFieldBorder
                )
                .align(Alignment.CenterVertically),
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
            placeholder = {
                Text(
                    text = "Search for guilds & members",
                    fontSize = 12.sp,
                    fontFamily = gilroy
                )
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier,
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_search),
                    contentDescription = "Search Icon"
                )
            }
        )

        HorizontalSpacer(width = 24)


        Icon(
            modifier = Modifier,
            imageVector = ImageVector.vectorResource(id = R.drawable.bellsimple),
            contentDescription = "Search Icon"
        )

        HorizontalSpacer(width = 24)


        Icon(
            modifier = Modifier,
            imageVector = ImageVector.vectorResource(id = R.drawable.paperplanetilt),
            contentDescription = "Search Icon"
        )


    }
}

@Composable
fun HorizontalSpacer(width: Int) {
    Spacer(modifier = Modifier.width(width = width.dp))

}

@Preview(showSystemUi = true)
@Composable
fun SearchBarPreview() {
   // UnfocusedSearchBar()
}