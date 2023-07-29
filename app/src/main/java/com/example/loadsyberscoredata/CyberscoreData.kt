package com.example.loadsyberscoredata

data class CyberscoreData(
    val rows: List<Match>
)

class Match(
    val id: String
)