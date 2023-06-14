package com.example.puconnect.presentation.networkscreen.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puconnect.mockdata.network.NetworkUserData
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@Composable
fun NetworkUserInfoSec3(
    networkUserData: NetworkUserData
) {
    Column (
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            networkUserData.skills.take(4).forEach {skillName ->
                SkillChip(skillName = skillName)
            }
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            SkillChip(skillName = networkUserData.skills[4])
            SkillChip(skillName = "+${networkUserData.skills.size - 5}")
        }
    }


}

@Composable
fun SkillChip(
    skillName: String
) {
    Box (
        modifier = Modifier
            .height(23.dp)
            .wrapContentWidth()
            .border(
                shape = RoundedCornerShape(4.dp),
                width = (0.5).dp,
                color = textFieldBorder
            )
        ,
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = skillName,
            fontFamily = gilroy,
            fontWeight = FontWeight.W500,
            fontSize = 10.sp,
            lineHeight = 12.13.sp,
            color = textFieldBorder
        )
    }
}