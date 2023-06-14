package com.example.puconnect.mockdata.home

import com.example.puconnect.R
import com.example.puconnect.presentation.navigation.Destinations


val codeGuild = Guild(iconId = R.drawable.code, guildName = "Coding Guild", destination = Destinations.CodingGuildScreen)
val designGuild = Guild(iconId = R.drawable.pennib, guildName = "Design Guild", destination = Destinations.DesignGuildScreen)
val chemGuild = Guild(iconId = R.drawable.testtube, guildName = "Chem Guild", destination = Destinations.ChemGuildScreen)
val artGuild = Guild(iconId = R.drawable.palette, guildName = "Art Guild", destination = Destinations.ArtGuildScreen)
val aiGuild = Guild(iconId = R.drawable.magicwand, guildName = "AI Guild", destination = Destinations.AiGuildScreen)

val guildList = listOf<Guild>(
    codeGuild,
    designGuild,
    chemGuild,
    artGuild,
    aiGuild
    )

data class Guild(
    val iconId: Int,
    val guildName: String,
    val destination: Destinations
)