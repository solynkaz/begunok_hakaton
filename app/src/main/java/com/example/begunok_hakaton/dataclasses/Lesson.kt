package com.example.begunok_hakaton.dataclasses

data class Lesson(
    val id: Int,
    val name: String?,
    val date: String?,
    val theme: String?,
    val teacher: String?,
    val presence: Boolean?,
    val type : String,
    val maxBall : String?,
    val currentBall: String?,
)
