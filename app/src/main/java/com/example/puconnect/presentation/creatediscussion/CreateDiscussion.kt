package com.example.puconnect.presentation.creatediscussion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.puconnect.mockdata.home.guildList
import com.example.puconnect.presentation.common.BottomOutlineTextField
import com.example.puconnect.presentation.common.BottomOutlineTextField2
import com.example.puconnect.presentation.common.SwipeButton
import com.example.puconnect.presentation.homescreen.components.HorizontalSpacer
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateDiscussion(
    navController: NavHostController
) {

    var topic by remember {
        mutableStateOf("")
    }

    var subtitle by remember {
        mutableStateOf("")
    }

    var isExapanded by remember {
        mutableStateOf(false)
    }

    var selectedGuild by remember {
        mutableStateOf("Select a Guild")
    }

    val onGuildSelected: (String) -> Unit = { guildName ->
        selectedGuild = guildName
        isExapanded = false
    }

    Column (
        modifier = Modifier.fillMaxSize().padding(bottom = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        ) {
            TopAppBar(
                title = {
                    Text(
                        fontFamily = gilroy,

                        text = "Start a discussion",
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp,
                        lineHeight = 19.6.sp,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        modifier = Modifier.padding(start = 2.dp),
                        onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.arrowleft),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Black)
            )




            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(20.dp)
            ) {
                Spacer(modifier = Modifier.height(31.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ellipse_4),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                    )

                    HorizontalSpacer(width = 16)

                    Text(
                        fontFamily = gilroy,

                        text = "Posting to:",
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        lineHeight = 17.15.sp,
                        color = textFieldBorder
                    )

                    HorizontalSpacer(width = 16)

                    ExposedDropdownMenuBox(
                        expanded = isExapanded,
                        onExpandedChange = { isExapanded = it }) {

                        DropDownChip(
                            onClick = {},
                            modifier = Modifier.menuAnchor(),
                            isExpanded = isExapanded
                        )

                        ExposedDropdownMenu(
                            modifier = Modifier

                                .border(
                                    shape = RoundedCornerShape(10.dp),
                                    color = textFieldBorder,
                                    width = (0.5).dp
                                )
                                .clip(RoundedCornerShape(10.dp))
                                .background(
                                    shape = RoundedCornerShape(10.dp),
                                    color = Color.White
                                )
                                .width(134.dp)
                                .padding(horizontal = 10.dp)
                            ,
                            expanded = isExapanded,
                            onDismissRequest = { isExapanded = false }
                        ) {

                            guildList.forEach { guild ->

                                GuildItemChip2(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    iconId = guild.iconId,
                                    labelName = guild.guildName,
                                    onClick = { onGuildSelected(guild.guildName) }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))


                BottomOutlineTextField(
                    placeholder = "What do you want to discuss about?",
                    value = topic,
                    onValueChange = { topic = it })

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    fontFamily = gilroy,

                    text = "${topic.length}/150",
                    fontWeight = FontWeight.W600,
                    fontSize = 12.sp,
                    lineHeight = 14.7.sp,
                    color = textFieldBorder
                )

                Spacer(modifier = Modifier.height(40.dp))

                BottomOutlineTextField2(
                    placeholder = "Your discussion subtitle (optional)",
                    value = subtitle,
                    onValueChange = { subtitle = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    fontFamily = gilroy,

                    text = "${subtitle.length}/500",
                    fontWeight = FontWeight.W600,
                    fontSize = 12.sp,
                    lineHeight = 14.7.sp,
                    color = textFieldBorder
                )

            }

        }

        SwipeButton()
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownChip(
    isExpanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    AssistChip(
        modifier = modifier
            .height(28.dp)
            .width(134.dp),
        shape = RoundedCornerShape(31.dp),
        onClick = { onClick() },
        label = {
            Text(
                text = "Select a Guild",
                color = Color.Black,
                fontFamily = gilroy,
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                lineHeight = 14.56.sp
            ) },
        border = AssistChipDefaults.assistChipBorder(
            borderColor = textFieldBorder,
            borderWidth = (0.5).dp
        ),
        trailingIcon = {
            Icon(
                modifier = Modifier.size(12.dp),
                imageVector = ImageVector
                    .vectorResource(id = if (isExpanded) R.drawable.caretup else R.drawable.vector),
                contentDescription = null)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuildItemChip2(
    onClick: () -> Unit,
    iconId: Int,
    labelName: String,
    modifier: Modifier = Modifier
) {

    Column (){
        Spacer(modifier = Modifier.height(5.dp))

        AssistChip(
            modifier = modifier
                .height(22.dp)
                .width(114.dp),
            shape = RoundedCornerShape(31.dp),
            onClick = { onClick() },
            label = {
                Text(
                    text = labelName,
                    color = Color.Black,
                    fontFamily = gilroy,
                    fontWeight = FontWeight.W500,
                    fontSize = 8.sp,
                    lineHeight = 9.7.sp
                ) },
            border = AssistChipDefaults.assistChipBorder(
                borderColor = textFieldBorder,
                borderWidth = (0.25).dp
            ),
            leadingIcon = {
                Box(
                    modifier = Modifier
                        .size(14.dp)
                        .clip(CircleShape)
                        .background(color = Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(8.dp),
                        imageVector = ImageVector.vectorResource(id = iconId),
                        contentDescription = "code guild",
                        tint = Color.White
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(5.dp))
    }
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
fun CreateDiscussionPreview() {
    //CreateDiscussion()
}