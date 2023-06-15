package com.example.puconnect.presentation.common

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.puconnect.ui.theme.gilroy
import com.example.puconnect.ui.theme.textFieldBorder

@Composable
fun BottomOutlineTextField(placeholder: String, value: String, onValueChange: (String) -> Unit) {

    BasicTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontFamily = gilroy,

            fontWeight = FontWeight.W600,
            fontSize = 16.sp,
            lineHeight = 19.6.sp,
            color = textFieldBorder
        ),
        decorationBox = { innerTextField ->
            Row(modifier = Modifier.fillMaxWidth()) {
                if (value.isEmpty()) {
                    Text (
                        fontFamily = gilroy,

                        text = placeholder,
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp,
                        lineHeight = 19.6.sp,
                        color = textFieldBorder
                    )
                }
            }
            innerTextField()
        }
    )
}

@Composable
fun BottomOutlineTextField2(placeholder: String, value: String, onValueChange: (String) -> Unit) {

    BasicTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            lineHeight = 16.98.sp,
            color = textFieldBorder
        ),
        decorationBox = { innerTextField ->
            Row(modifier = Modifier.fillMaxWidth()) {
                if (value.isEmpty()) {
                    Text (
                        fontFamily = gilroy,

                        text = placeholder,
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp,
                        lineHeight = 16.98.sp,
                        color = textFieldBorder
                    )
                }
            }
            innerTextField()
        }
    )
}