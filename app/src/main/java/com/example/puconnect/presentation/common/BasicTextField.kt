package com.example.puconnect.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

//@Composable
//fun ProfileScreenTextField(
//    placeholder: String,
//    value: String,
//    onValueChange: (String) -> Unit,
//    trailingIcon : Int = 1,
//    ) {
//
//    BasicTextField(
//        modifier = Modifier
//            .fillMaxWidth(),
//
//        value = value,
//        onValueChange = onValueChange,
//        textStyle = TextStyle(
//            fontFamily = gilroy,
//
//            fontWeight = FontWeight.W500,
//            fontSize = 14.sp,
//            lineHeight = 16.98.sp,
//            color = Color.Black
//        ),
//        decorationBox = { innerTextField ->
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp)
//                    .border(
//                        shape = RoundedCornerShape(4.dp),
//                        color = textFieldBorder,
//                        width = (0.25).dp
//                    )
//                    .padding(horizontal = 12.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                if (value.isEmpty()) {
//                    Text (
//                        fontFamily = gilroy,
//                        text = placeholder,
//                        fontWeight = FontWeight.W500,
//                        fontSize = 14.sp,
//                        lineHeight = 16.98.sp,
//                        color = textFieldBorder
//                    )
//                }
//
//                if(trailingIcon != 1) {
//                    Icon(
//                        modifier = Modifier.size(20.dp),
//                        imageVector = ImageVector.vectorResource(id = trailingIcon),
//                        contentDescription = null,
//                        tint = Color.Unspecified
//                    )
//                }
//            }
//            innerTextField()
//        }
//    )
//}


@Composable
fun ProfileScreenTextField(
    text: String,
    iconId: Int = 1,
    color: Color = Color.Black,
    backGroundColor: Color = Color.White
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(color = backGroundColor)
                .border(
                    shape = RoundedCornerShape(4.dp),
                    color = textFieldBorder,
                    width = (0.25).dp
                )
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
                Text (
                    fontFamily = gilroy,
                    text = text,
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                    lineHeight = 16.98.sp,
                    color = color
                )

            if (iconId != 1) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = ImageVector.vectorResource(id = iconId),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }


        }
}

@Composable
@Preview(showBackground = true)
fun TextFieldPreview() {
   ProfileScreenTextField(text = "Siddhi Patel")
}