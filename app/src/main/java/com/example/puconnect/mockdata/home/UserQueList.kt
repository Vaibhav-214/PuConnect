package com.example.puconnect.mockdata.home

import com.example.puconnect.R

val siddhiQue = UserQueData(
    questionId = "123",
    userName = "Siddhi Patel",
    userPhoto = R.drawable.ellipse_4,
    question = "How i can use Chatgpt to code my figma design?",
    guildList = listOf<Guild>(aiGuild, designGuild),
    engageCount = 9,
    queDetails = "How can I leverage the capabilities of ChatGPT to facilitate the conversion of my Figma designs into code?"
)

val siddhiQueCode2 = UserQueData(
    questionId = "124",
    userName = "Siddhi Patel",
    userPhoto = R.drawable.ellipse_4,
    question = "What are fundamental principles of OOP?",
    guildList = listOf<Guild>(codeGuild),
    engageCount = 9,
    queDetails = "How can I leverage the capabilities of ChatGPT to facilitate the conversion of my Figma designs into code?"
)

val siddhiQueCode3 = UserQueData(
    questionId = "125",
    userName = "Siddhi Patel",
    userPhoto = R.drawable.ellipse_4,
    question = "Key graphic design principles?",
    guildList = listOf<Guild>(codeGuild),
    engageCount = 9,
    queDetails = "How can I leverage the capabilities of ChatGPT to facilitate the conversion of my Figma designs into code?"
)



val mukulQue = UserQueData(
    questionId = "126",
    userName = "Mukul Sapre",
    userPhoto = R.drawable.userphoto2,
    question = "How to make methylamine?",
    guildList = listOf<Guild>(codeGuild),
    engageCount = 8,
    queDetails = "How can I leverage the capabilities of ChatGPT to facilitate the conversion of my Figma designs into code?"
)

val mukulQue2 = UserQueData(
    questionId = "127",
    userName = "Mukul Sapre",
    userPhoto = R.drawable.userphoto2,
    question = "How can I improve my coding skills and efficiency?",
    guildList = listOf<Guild>(codeGuild),
    engageCount = 8,
    queDetails = "How can I leverage the capabilities of ChatGPT to facilitate the conversion of my Figma designs into code?"
)

val mukulQue3 = UserQueData(
    questionId = "128",
    userName = "Mukul Sapre",
    userPhoto = R.drawable.userphoto2,
    question = "Enhance design skills creatively?",
    guildList = listOf<Guild>(codeGuild),
    engageCount = 8,
    queDetails = "How can I leverage the capabilities of ChatGPT to facilitate the conversion of my Figma designs into code?"
)
val mukulQue4 = UserQueData(
    questionId = "129",
    userName = "Mukul Sapre",
    userPhoto = R.drawable.userphoto2,
    question = "Best practices for intuitive interfaces?",
    guildList = listOf<Guild>(codeGuild),
    engageCount = 8,
    queDetails = "How can I leverage the capabilities of ChatGPT to facilitate the conversion of my Figma designs into code?"
)

val mukulQue5 = UserQueData(
    questionId = "130",
    userName = "Mukul Sapre",
    userPhoto = R.drawable.userphoto2,
    question = "Common design UX patterns?",
    guildList = listOf<Guild>(codeGuild),
    engageCount = 8,
    queDetails = "How can I leverage the capabilities of ChatGPT to facilitate the conversion of my Figma designs into code?"
)
val joeQue = UserQueData(
    questionId = "131",
    userName = "Joe don",
    userPhoto = R.drawable.userphoto2,
    question = "Types of programming data structures?",
    guildList = listOf<Guild>(codeGuild),
    engageCount = 8,
    queDetails = "How can I leverage the capabilities of ChatGPT to facilitate the conversion of my Figma designs into code?"
)

val ayushQue = UserQueData(
    questionId = "132",
    userName = "Ayush shah",
    userPhoto = R.drawable.userphoto2,
    question = "Esssential code security practices?",
    guildList = listOf<Guild>(codeGuild),
    engageCount = 8,
    queDetails = "How can I leverage the capabilities of ChatGPT to facilitate the conversion of my Figma designs into code?"
)

val userQueList = listOf(
    siddhiQue,
    mukulQue,
    ayushQue,
    joeQue,
    siddhiQueCode2,
    mukulQue2, mukulQue3, mukulQue4, mukulQue5, siddhiQueCode3
)

val codeGuildQueList = listOf<UserQueData>(siddhiQueCode2, mukulQue2, joeQue, ayushQue, siddhiQueCode2)
val designGuildQueList = listOf<UserQueData>(siddhiQueCode3, mukulQue3, mukulQue4, mukulQue5, mukulQue3)
val commonGuildQueList = listOf<UserQueData>(siddhiQue, mukulQue, mukulQue, mukulQue, mukulQue)

data class UserQueData(
    val questionId: String,
    val userName: String,
    val userPhoto: Int,
    val question: String,
    val guildList: List<Guild>,
    val engageCount: Int,
    val queDetails: String,
)