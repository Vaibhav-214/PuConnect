package com.example.puconnect.presentation.profilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.puconnect.R
import com.example.puconnect.mockdata.profile.profileData
import com.example.puconnect.presentation.common.ProfileScreenTextField
import com.example.puconnect.presentation.common.VerticalSpacer
import com.example.puconnect.presentation.homescreen.components.HorizontalSpacer
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun EditProfileScreen(
    navController: NavHostController
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        TopAppBar(
            title = {
                Text(
                    fontFamily = gilroy,

                    text = "Edit Profile",
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
            actions = {
                Row(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .width(60.dp)
                        .height(32.dp)
                        .background(
                            shape = RoundedCornerShape(32.dp),
                            color = Color.White,
                        ).clickable { navController.popBackStack() },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Save",
                        fontFamily = gilroy,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 14.56.sp,
                        color = Color.Black
                    )

                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Black)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ) {

            item {

                VerticalSpacer(height = 31)

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Box {
                        Image(
                            modifier = Modifier.size(108.dp),
                            painter = painterResource(id = R.drawable.siddhiimage),
                            contentDescription = null)

                        Icon(
                            modifier = Modifier.size(32.dp).offset(x= 78.dp, y = 78.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.editdp),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }

                }

                VerticalSpacer(height = 19)

                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "full Name",
                    fontFamily = gilroy,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 17.15.sp,
                    color = Color.Black
                )

                VerticalSpacer(height = 8)

                ProfileScreenTextField(text = profileData.fullName,)

                VerticalSpacer(height = 26)


                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = "Username",
                        fontFamily = gilroy,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600,
                        lineHeight = 17.15.sp,
                        color = Color.Black
                    )

                    Text(
                        text = "10/32",
                        fontFamily = gilroy,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600,
                        lineHeight = 17.15.sp,
                        color = Color.Black
                    )
                }


                VerticalSpacer(height = 8)

                ProfileScreenTextField(text = profileData.userName,iconId = R.drawable.checkcircle)

                VerticalSpacer(height = 24)

                Text(
                    text = "Headline",
                    fontFamily = gilroy,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 17.15.sp,
                    color = Color.Black
                )

                VerticalSpacer(height = 10)


                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "Use this space to describe yourself in one line.",
                        fontFamily = gilroy,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 14.56.sp,
                        color = Color.Black
                    )

                    Text(
                        text = "26/120",
                        fontFamily = gilroy,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 14.56.sp,
                        color = Color.Black
                    )
                }

                VerticalSpacer(height = 16)

                ProfileScreenTextField(text = profileData.role,)

                VerticalSpacer(height = 24)

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Skills",
                        fontFamily = gilroy,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600,
                        lineHeight = 17.15.sp,
                        color = Color.Black
                    )


                    Row(
                        modifier = Modifier
                            .width(77.dp)
                            .height(32.dp)
                            .border(
                                shape = RoundedCornerShape(32.dp),
                                color = textFieldBorder,
                                width = (0.25).dp
                            ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Edit",
                            fontFamily = gilroy,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 14.56.sp,
                            color = Color.Black
                        )

                        HorizontalSpacer(width = 8)

                        Icon(
                            modifier = Modifier.size(16.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.pencilsimple),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }

                VerticalSpacer(height = 8)

                FlowRow (
                    maxItemsInEachRow = 2,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    profileData.skillsList.forEach {skill->
                        Column () {
                            VerticalSpacer(height = 8)

                            SkillChip(skill = skill)

                            VerticalSpacer(height = 8)
                        }

                    }
                }

                VerticalSpacer(height = 16)

                Text(
                    text = "My Projects",
                    fontFamily = gilroy,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 17.15.sp,
                    color = Color.Black
                )

                VerticalSpacer(height = 16)

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xffF5F5F5), shape = RoundedCornerShape(4.dp))
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        modifier = Modifier.align(Alignment.Start),
                        text = "Project Attachment",
                        fontFamily = gilroy,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 16.98.sp,
                        color = Color.Black
                    )

                    //continue

                    VerticalSpacer(height = 16)

                    Row(
                        modifier = Modifier
                            .height(48.dp)
                            .padding(horizontal = 20.dp)
                            .border(
                                shape = RoundedCornerShape(24.dp),
                                color = Color.Black,
                                width = (0.25).dp
                            )
                            .padding(horizontal = 5.dp, vertical = 4.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .height(40.dp)
                                .background(shape = RoundedCornerShape(24.dp), color = Color.Black)
                                .weight(0.5f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Add attachment",
                                fontFamily = gilroy,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.W500,
                                lineHeight = 14.56.sp,
                                color = Color.White
                            )

                            HorizontalSpacer(width = 3)

                            Icon(
                                modifier = Modifier.size(16.dp),
                                imageVector = ImageVector.vectorResource(id = R.drawable.paperclip),
                                contentDescription = null,
                                tint = Color.White
                            )


                        }

                        Row(
                            modifier = Modifier
                                .height(40.dp)
                                .weight(0.5f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Add links",
                                fontFamily = gilroy,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.W500,
                                lineHeight = 14.56.sp,
                                color = Color.Black
                            )

                            HorizontalSpacer(width = 3)

                            Icon(
                                modifier = Modifier.size(16.dp),
                                imageVector = ImageVector.vectorResource(id = R.drawable.globehemispherewest),
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }


                    }

                    VerticalSpacer(height = 20)

                    Text(
                        text = "Select attachments to upload",
                        fontFamily = gilroy,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 14.56.sp,
                        color = textFieldBorder
                    )

                    VerticalSpacer(height = 12)

                    Row(
                        modifier = Modifier
                            .width(97.dp)
                            .height(32.dp)
                            .border(
                                shape = RoundedCornerShape(32.dp),
                                color = textFieldBorder,
                                width = (0.25).dp
                            ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Upload",
                            fontFamily = gilroy,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 14.56.sp,
                            color = Color.Black
                        )

                        HorizontalSpacer(width = 8)

                        Icon(
                            modifier = Modifier.size(16.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.uploadsimple),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }


                    VerticalSpacer(height = 20)

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Project Title",
                            fontFamily = gilroy,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 16.98.sp,
                            color = Color.Black
                        )

                        Text(
                            text = "0/32",
                            fontFamily = gilroy,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W600,
                            lineHeight = 17.15.sp,
                            color = Color.Black
                        )
                    }

                    VerticalSpacer(height = 16)

                    ProfileScreenTextField(text = "Eg. Landing page for food ordering app", color = textFieldBorder)

                    VerticalSpacer(height = 13)

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            modifier = Modifier.size(16.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.star),
                            contentDescription = null,
                            tint = Color.Black
                        )

                        HorizontalSpacer(width = 4)


                        Text(
                            text = "Mark this project as featured (Your best project).",
                            fontFamily = gilroy,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 12.13.sp,
                            color = Color.Black
                        )

                    }

                    VerticalSpacer(height = 24)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .background(color = Color.Black, shape = RoundedCornerShape(4.dp)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = "Save project",
                            fontFamily = gilroy,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 14.56.sp,
                            color = Color.White
                        )

                        HorizontalSpacer(width = 8)


                        Icon(
                            modifier = Modifier.size(14.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.check),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                }


                VerticalSpacer(height = 24)

                Text(
                    text = "My Links",
                    fontFamily = gilroy,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 17.15.sp,
                    color = Color.White
                )

                VerticalSpacer(height = 12)

                Text(
                    text = "Portfolio link, Github link, Behance link etc",
                    fontFamily = gilroy,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 14.56.sp,
                    color = textFieldBorder
                )

                VerticalSpacer(height = 8)

                ProfileScreenTextField(
                    text = "https://www.website.com/demo-page",
                    iconId = R.drawable.xcircle,
                    backGroundColor = Color(0xffF5F5F5)
                    )

                VerticalSpacer(height = 24)

                Text(
                    text = "Link URL",
                    fontFamily = gilroy,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 17.15.sp,
                    color = Color.Black
                )

                VerticalSpacer(height = 8)

                ProfileScreenTextField(text = "https://www.website.com/demo-page")

                VerticalSpacer(height = 16)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(4.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Save link",
                        fontFamily = gilroy,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 14.56.sp,
                        color = Color.White
                    )
                }

                VerticalSpacer(height = 24)

                Text(
                    text = "Phone Number (Optional)",
                    fontFamily = gilroy,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 17.15.sp,
                    color = Color.Black
                )

                VerticalSpacer(height = 12)

                Text(
                    text = "it’ll be shared only with the recruiters. Adding phone number\n" +
                            "helps you get hired faster.",
                    fontFamily = gilroy,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 14.56.sp,
                    color = textFieldBorder
                )

                VerticalSpacer(height = 8)

                ProfileScreenTextField(text = "Eg. 9999888822", color = textFieldBorder)

                VerticalSpacer(height = 24)

                Text(
                    text = "Studies in",
                    fontFamily = gilroy,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 17.15.sp,
                    color = Color.Black
                )

                VerticalSpacer(height = 8)

                ProfileScreenTextField(text = "PIET")
                
                VerticalSpacer(height = 24)

                Text(
                    text = "Location",
                    fontFamily = gilroy,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 17.15.sp,
                    color = Color.Black
                )

                VerticalSpacer(height = 8)

                ProfileScreenTextField(text = "Vadodara, Gujarat")

                VerticalSpacer(height = 40)



            }


        }

    }
}

@Composable
@Preview(showBackground = true)
fun EditProfileScreenPreview() {

    //EditProfileScreen()
}