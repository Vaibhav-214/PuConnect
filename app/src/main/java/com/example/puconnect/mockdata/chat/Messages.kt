package com.example.puconnect.mockdata.chat

import androidx.compose.ui.graphics.Color
import com.example.puconnect.ui.theme.msggreen
import com.example.puconnect.ui.theme.msgpurple
import com.example.puconnect.ui.theme.msgred

data class ChatMsg(
    val user: String,
    val color: Color,
    val message: String
)


val msg1 = ChatMsg(user = "Abhishek Gharia", color = msgred,
    message = "Well, with ChatGPT, you can have a conversation to assist in converting Figma " +
            "designs into code. It analyzes the design elements and provides code snippets or " +
            "step-by-step guidance.")

val msg2 = ChatMsg(user = "Vaishnavi Shah", color = msgpurple,
    message = "Correct, ChatGPT uses machine learning to analyze the design you share. It can" +
            " recognize components like buttons, text fields, and layouts, and understand their " +
            "relationships")
val msg3 = ChatMsg(user = "Ved Joshi", color = msggreen,
    message = "I'm excited to try it out and see how ChatGPT can streamline my design-to-code workflow."
    )

val msgList = listOf<ChatMsg>(msg1, msg2, msg3, msg1, msg2, msg3)