package com.example.begunok_hakaton.dataclasses.StudentDataClasses

import androidx.room.ForeignKey
import androidx.room.PrimaryKey

data class Arrear(
    val idLesson: Int,
    val arrearDate: String,
    val arrearGrade: String,
    var arrearSended: Boolean,
    val arrearAccepted: Boolean,
 /* val arrearId: Int,
    val lessonId: Int,
    val arrearType: String, //Индивидуальный протокол защиты курсовой работы / курсового проекта
    val attestationType: String, //аттестация в индивидуальные сроки/первая повторная аттестация/вторая повторная аттестация
    val facultyName: String,
    val arrearNumber: Int,
    val arrearDateFrom: String,
    val examListNumber: String,
    val examListDateFrom: String,
    val studentFIO: String,
    val studentBookNumber: String,
    val specialtyNumber: String,
    val course: String,
    val group: String,*/
)
