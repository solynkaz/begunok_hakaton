package com.example.begunok_hakaton.dataclasses.StudentDataClasses

data class Student(
    val id: Int,
    val fio: String,
    val lessons: ArrayList<Lesson>,
    val active_arrears: ArrayList<Arrear>?,
)
