package com.example.puconnect.presentation.workscreen.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puconnect.R
import com.example.puconnect.mockdata.network.netUser1
import com.example.puconnect.mockdata.work.WorkPostData
import com.example.puconnect.mockdata.work.work1
import com.example.puconnect.presentation.homescreen.components.HorizontalSpacer
import com.example.puconnect.presentation.networkscreen.common.NetworkUserInfo
import com.example.puconnect.presentation.networkscreen.common.SkillChip
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@Composable
fun WorkPostSec2(
    workPostData: WorkPostData
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = workPostData.description,
            fontFamily = gilroy,
            fontWeight = FontWeight.W600,
            fontSize = 12.sp,
            lineHeight = 14.7.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            workPostData.skills.forEach { skill ->
                SkillChip(skillName = skill)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
                
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.money),
                    contentDescription = null,
                    tint = Color.Unspecified
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = workPostData.salary,
                    fontFamily = gilroy,
                    fontWeight = FontWeight.W500,
                    fontSize = 12.sp,
                    lineHeight = 14.56.sp,
                    color = textFieldBorder
                )
            }
            
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.whatsapplogo),
                    contentDescription = null
                )
                
                Spacer(modifier = Modifier.width(16.dp))


                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.sharenetwork),
                    contentDescription = null
                )
                
                
            }
        }
    }
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
fun WorkPostSec2Preview() {
    WorkPostSec2(workPostData = work1)
}