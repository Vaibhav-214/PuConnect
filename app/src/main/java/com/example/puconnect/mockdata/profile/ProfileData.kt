package com.example.puconnect.mockdata.profile

data class ProfileData(
    val fullName: String = "Siddhi Patel",
    val userName: String = "Siddhi1803",
    val role: String = "Web Developer - UI Designer",
    val skillsList: List<String> = listOf("Figma","Photoshop","Web Development","Photography","Android Development","Canva"),
    val projectTitle: String = "",
    val link: String = "https://www.website.com/demo-page",
    val phoneNumber: String ="",
    val school: String = "PIET",
    val location: String = "Vadodara, Gujarat"
)

val profileData = ProfileData()