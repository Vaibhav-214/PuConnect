package com.example.puconnect.presentation.homescreen.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.presentation.navigation.Destinations
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder
import com.example.puconnect.ui.theme.textFieldPlaceholder

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun UnfocusedSearchBar(
    navController: NavHostController,
    searchText: String,
    onTextChange: (String) -> Unit,
   // onClick: () -> Unit,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp

    val keyboardController = LocalSoftwareKeyboardController.current

    val isKeyboardOpen by keyboardAsState()

    Log.d("VV", "$isKeyboardOpen")

    val textFieldSize by animateFloatAsState(
        targetValue = if (isKeyboardOpen) 0.774f else 0.651f
    )




    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(
                visible = isKeyboardOpen,
                enter = slideInHorizontally(
                    initialOffsetX = { -it },
                    animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
                ),
                exit = slideOutHorizontally(
                    targetOffsetX = { -it },
                    animationSpec = tween(durationMillis = 300, easing = FastOutLinearInEasing)
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(0.5f)
                ) {
                    Icon(
                        modifier = Modifier.clickable { keyboardController?.hide() },
                        imageVector = ImageVector.vectorResource(id = R.drawable.arrowleft),
                        contentDescription = "Search Icon"
                    )

                    HorizontalSpacer(width = 24)

                }
            }



                TextField(
                    shape = RoundedCornerShape(4.dp),
                    value = searchText,
                    onValueChange = { onTextChange(it) },
                    modifier = Modifier
                        .width((screenWidth*textFieldSize).dp)//0.72f
                        .background(color = Color.Transparent)
                        .animateContentSize(
                            animationSpec = tween(durationMillis = 400)
                        )
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

            }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.requiredWidth(96.dp)
    ) {


    AnimatedVisibility(
            visible = !isKeyboardOpen,
            enter = slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(durationMillis = 300, easing = FastOutLinearInEasing)
            )
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                HorizontalSpacer(width = 24)


                Icon(
                    modifier = Modifier.clickable {
                        navController.navigate(Destinations.NotificationScreen.route)
                    },
                    imageVector = ImageVector.vectorResource(id = R.drawable.bellsimple),
                    contentDescription = "Search Icon"
                )

                HorizontalSpacer(width = 24)


                Icon(
                    modifier = Modifier.clickable {
                        navController.navigate(Destinations.NewMessageScreen.route)
                    },
                    imageVector = ImageVector.vectorResource(id = R.drawable.paperplanetilt),
                    contentDescription = "Search Icon"
                )

            }

        }

    }
    }
}

@Composable
fun HorizontalSpacer(width: Int) {
    Spacer(modifier = Modifier.width(width = width.dp))

}

@Composable
fun keyboardAsState(): State<Boolean> {
    val isImeVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0
    return rememberUpdatedState(isImeVisible)
}

@Preview(showSystemUi = true)
@Composable
fun SearchBarPreview() {
    //UnfocusedSearchBar(searchText = "", onTextChange = {})
}