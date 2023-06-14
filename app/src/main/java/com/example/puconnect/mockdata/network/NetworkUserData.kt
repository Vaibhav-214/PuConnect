package com.example.puconnect.mockdata.network

import com.example.puconnect.R

data class NetworkUserData(
    val profilePic: Int,
    val name: String,
    val address: String,
    val role: String,
    val skills: List<String>
)

val netUser1 = NetworkUserData(
    profilePic = R.drawable.userphoto1,
    name = "Ayush Naik",
    address = "Vadodara, Gujarat",
    role = "Android developer, Cloud engineer",
    skills = listOf("Android Development", "Frameworks", "Architecture","Kotlin", "Cloud Storage", "Material 3", "Design" )
)

val netUser2 = NetworkUserData(
    profilePic = R.drawable.userphoto3,
    name = "Jeet Shah",
    address = "Vadodara, Gujarat",
    role = "Sketch Artist",
    skills = listOf("Sketching", "Pencils", "Techniques","Shadows", "Canvas", "Portrait")
)

val netUser3 = NetworkUserData(
    profilePic = R.drawable.userphoto4,
    name = "Ansh Mehra",
    address = "Delhi",
    role = "AI Enthusiast",
    skills = listOf("AI", "Tools", "Mid Journey","Prompt Engineering", "Chatgpt", "Bard", "Others")
)

val netUserList = listOf<NetworkUserData>(netUser1, netUser2, netUser3, netUser1)

