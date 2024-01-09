package com.example.amiiboverse.newtork

data class Amiibos(
    val amiibo: List<Character>
)
//data class to especificate the retrieved data
data class Character(
    val amiiboSeries: String,
    val character: String,
    val image: String,
    val name: String
    )
