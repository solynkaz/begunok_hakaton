package com.example.begunok_hakaton.dataclasses.GroupDataClasses

import com.example.begunok_hakaton.dataclasses.StudentDataClasses.Student

data class Group(
    val id: Int,
    val students: ArrayList<Student>,
    val groupName: String
)
