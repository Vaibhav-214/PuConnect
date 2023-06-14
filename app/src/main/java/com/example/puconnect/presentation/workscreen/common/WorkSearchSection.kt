package com.example.puconnect.presentation.workscreen.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puconnect.R
import com.example.puconnect.mockdata.network.netUser1
import com.example.puconnect.mockdata.work.work1
import com.example.puconnect.presentation.networkscreen.common.CustomButton
import com.example.puconnect.presentation.networkscreen.common.CustomButton3
import com.example.puconnect.ui.theme.addressColor
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder
import com.example.puconnect.ui.theme.textFieldPlaceholder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkSearchSection(
    onMyApplicationClick : () -> Unit = {} ,
    onExploreClick: () -> Unit = {},
    exploreSelected: Boolean = true
) {

    var searchText by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            shape = RoundedCornerShape(4.dp),
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .height(44.dp)
                .border(
                    width = (0.25).dp,
                    shape = RoundedCornerShape(4.dp),
                    color = textFieldBorder
                ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedLabelColor = Color.Transparent,
                placeholderColor = textFieldPlaceholder,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = "Search for Jobs",
                    fontFamily = gilroy,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 14.56.sp,
                    color = addressColor
                )
            },
            textStyle = TextStyle(
                fontFamily = gilroy,
                fontSize = 12.sp,
                lineHeight = 14.56.sp,
                fontWeight = FontWeight.W500,
                color = addressColor

            ),
            leadingIcon = {
                Icon(
                    modifier = Modifier,
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_search),
                    contentDescription = "Search Icon"
                )
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier,
                    imageVector = ImageVector.vectorResource(id = R.drawable.funnel),
                    contentDescription = "Search Icon"
                )
            }
            )



        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            CustomButton3(
                modifier = Modifier.weight(0.5f),
                exploreSelected = exploreSelected,
                onClick = { onExploreClick() },
                title = "Explore")

            Spacer(modifier = Modifier.width(12.dp))

            CustomButton3(
                modifier = Modifier.weight(0.5f),
                exploreSelected = !exploreSelected,
                onClick = { onMyApplicationClick() },
                title = "My Applications"
            )

       }

        Spacer(modifier = Modifier.height(13.dp))
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun WorkSearchSectionPreview() {
    WorkSearchSection(onExploreClick = { /*TODO*/ })
}