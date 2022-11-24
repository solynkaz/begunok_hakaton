package com.example.begunok_hakaton.dataclasses.StudentDataClasses

data class Lesson(
    val id: Int,
    val name: String?,
    var date: String?,
    val theme: String?,
    val teacher: String?,
    val presence: Boolean?,
    val type : String,
    val maxBall : String?,
    var currentBall: String?,
)
