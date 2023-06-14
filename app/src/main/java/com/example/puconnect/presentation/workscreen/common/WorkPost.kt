package com.example.puconnect.presentation.workscreen.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puconnect.mockdata.work.WorkPostData
import com.example.puconnect.mockdata.work.work1
import com.example.puconnect.presentation.networkscreen.common.NetworkUserInfoSec1
import com.example.puconnect.ui.theme.textFieldBorder

@Composable
fun WorkPost(
    workPostData: WorkPostData
) {

    Column (
        modifier = Modifier.fillMaxWidth()

    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
                .border(
                    shape = RoundedCornerShape(4.dp),
                    width = (0.25).dp,
                    color = textFieldBorder
                )
                .padding(8.dp)
        ) {

            WorkPostSec1(workPostData = workPostData)

            WorkPostSec2(workPostData = workPostData)
        }

        Spacer(modifier = Modifier.height(8.dp))

    }

}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun WorkPostPreview() {
    WorkPost(workPostData = work1)
}