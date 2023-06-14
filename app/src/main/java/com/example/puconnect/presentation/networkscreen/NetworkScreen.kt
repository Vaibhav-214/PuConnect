package com.example.puconnect.presentation.networkscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.puconnect.mockdata.network.netUserList
import com.example.puconnect.presentation.common.CustomTopAppBar
import com.example.puconnect.presentation.networkscreen.common.NetworkSearchSection
import com.example.puconnect.presentation.networkscreen.common.NetworkUserInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NetworkScreen(
    padding: PaddingValues
     //bottomNavigationBar: @Composable () -> Unit
) {


        Column (
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 20.dp),
        ) {
            CustomTopAppBar("Network")

            NetworkSearchSection()

            LazyColumn() {
                items(netUserList) { networkUserData ->
                    NetworkUserInfo(networkUserData = networkUserData)
                }
            }
        }


}


@Preview(showSystemUi = true)
@Composable
fun NetworkScreenPreview() {
    //NetworkScreen()
}