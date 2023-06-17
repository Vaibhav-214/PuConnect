package com.example.puconnect.presentation.profilescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.mockdata.profile.allGenres
import com.example.puconnect.presentation.common.VerticalSpacer
import com.example.puconnect.ui.theme.addressColor
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkillsScreen(
    navController: NavHostController
) {

    Scaffold (
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        fontFamily = gilroy,

                        text = "Skills",
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp,
                        lineHeight = 19.6.sp,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        modifier = Modifier.padding(start = 2.dp),
                        onClick = {
                             navController.popBackStack()
                        }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.arrowleft),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Black)
            )

        },
        bottomBar = {
            Column (
                modifier = Modifier.navigationBarsPadding()
            )  {
                VerticalSpacer(height = 16)

                Button(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 20.dp)
                        .background(
                            shape = RoundedCornerShape(4.dp),
                            color = Color.Black
                        ),
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {

                    Text(
                        fontFamily = gilroy,

                        text = "Save",
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        lineHeight = 17.15.sp,
                        color = Color.White
                    )

                }

                VerticalSpacer(height = 16)
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 20.dp)
        ) {


            MySkills()

            SkillSet()

        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySkills() {

    var searchText by remember {
        mutableStateOf("")
    }

    Column {

        VerticalSpacer(height = 32)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "My Skills",
                fontWeight = FontWeight.W600,
                fontFamily = gilroy,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                color = Color.Black
            )

            Text(
                text = "max 6",
                fontWeight = FontWeight.W400,
                fontFamily = gilroy,
                fontSize = 14.sp,
                lineHeight = 16.8.sp,
                color = textFieldBorder
            )
        }

        VerticalSpacer(height = 24)

        Text(
            text = "This helps us recommend you relevant gigs and people to connect with",
            fontWeight = FontWeight.W400,
            fontFamily = gilroy,
            fontSize = 13.sp,
            lineHeight = 15.6.sp,
            color = Color.Black
        )

        VerticalSpacer(height = 32)

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
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = "Search Skills like Figma, AWS",
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
        )

        VerticalSpacer(height = 24)

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillSet() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        allGenres.forEach {genreWithSkills ->
            item {
                Column {
                    Text(
                        text = genreWithSkills.genre,
                        fontFamily = gilroy,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W600,
                        lineHeight = 19.6.sp,
                        color = Color.Black
                    )

                    VerticalSpacer(height = 8)
                }
            }

            item {
                FlowRow (
                    maxItemsInEachRow = 2,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    genreWithSkills.skillList.forEach {skill->
                        Column () {
                            VerticalSpacer(height = 8)

                            SkillChip(skill = skill)

                            VerticalSpacer(height = 8)
                        }

                    }
                }
            }

            item {
                Column {
                    VerticalSpacer(height = 16)

                    Divider(modifier = Modifier.fillMaxWidth(), thickness = (0.5).dp, color = textFieldBorder)

                    VerticalSpacer(height = 16)
                }
            }

        }

    }
}

@Composable
fun SkillChip(skill: String) {
    Box (
        modifier = Modifier
            .height(32.dp)
            .border(shape = RoundedCornerShape(20.dp), color = Color.Black, width = (0.25).dp)
            .background(shape = RoundedCornerShape(20.dp), color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = skill,
            fontFamily = gilroy,
            fontSize = 12.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 14.56.sp,
            color = Color.Black
        )
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun SkillsScreenPreview() {
    //SkillChip(skill = "Android")
    //SkillsScreen()
}