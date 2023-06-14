package com.example.puconnect.mockdata.work

import com.example.puconnect.R

data class WorkPostData(
    val profilePic: Int,
    val organization: String,
    val address: String,
    val description: String,
    val skills: List<String>,
    val salary: String,
    //val generatedLink to share on other apps
)

val work1 = WorkPostData(
    profilePic = R.drawable.userphoto1,
    organization = "Minimal Dot",
    address = "Vadodara,Gujarat",
    description = "looking for a UI designer",
    skills = listOf("figma", "prototyping", "Visual Design"),
    salary = "₹8000 - ₹12000/month"
)

val workList = listOf(work1, work1, work1, work1)
