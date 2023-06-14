package com.example.puconnect.presentation.homescreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.puconnect.mockdata.home.navItems
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder


@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp

    var selectedScreenIndex by remember { mutableStateOf(0) }

    BottomAppBar(
        modifier = modifier.fillMaxWidth(),
        containerColor = Color.White,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                //.padding(horizontal = (screenWidth*0.064f).dp),

        ) {
            navItems.forEachIndexed { index, navItem ->
                BottomNavBarIcons(
                    iconId = navItem.iconId,
                    filledIconId = navItem.iconfilled,
                    screenName = navItem.screenName,
                    selected = index == selectedScreenIndex,
                    onClick = { selectedScreenIndex = index }
                )
            }
        }
    }
}

@Composable
fun BottomNavBarIcons(
    iconId: Int,
    filledIconId: Int,
    screenName: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = if (selected) filledIconId else iconId),
            contentDescription = null,
            tint = if (selected) Color.Black else textFieldBorder
        )

        Text(
            text = screenName,
            fontFamily = gilroy,
            fontWeight = FontWeight.W400,
            fontSize = 10.sp,
            lineHeight = 12.sp,
            color = if (selected) Color.Black else textFieldBorder
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}