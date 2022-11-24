package com.example.begunok_hakaton.screens

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.begunok_hakaton.R
import com.example.begunok_hakaton.dataclasses.GroupDataClasses.Group
import com.example.begunok_hakaton.dataclasses.StudentDataClasses.Student
import com.google.gson.Gson

@Composable
fun StudentRecord(
    student: Student,
    pref: SharedPreferences,
    NavOnBack: () -> Unit
) {
    val group: Group = Gson().fromJson(pref.getString("data",""), Group::class.java)
    Row(
        Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = R.drawable.group_174asd),
            contentDescription = "",
            alignment = Alignment.Center,
            alpha = 0.4f
        )
    }
    val lessonName = "Программирование"
    val yearOfStudy = "2022"
    Column() {
        TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "", modifier = Modifier.clickable {
                    NavOnBack()
                })
            }
            Text("", fontSize = 22.sp)
        }
        Text(
            "$lessonName",
            modifier = Modifier.padding(start = 15.dp),
            fontSize = 36.sp,
            fontWeight = FontWeight(500)
        )
        if (yearOfStudy != null) Text(
            "Год: $yearOfStudy - ${yearOfStudy.toInt() + 1}",
            Modifier.padding(start = 25.dp, bottom = 25.dp),
            fontSize = 18.sp,
            color = Color(0x80000000)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp)
        ) {
            for (lesson in student.lessons) {
                val lessonName1 = if (lesson.id % 2 == 0)
                    "Лекция" else "Практика"
                when (lesson.type.toInt()) {
                    1 -> {
                        item {
                            lessonCard(
                                cardType = lesson.type.toInt(),
                                lessonName = lessonName1,
                                lessonDate = lesson.date,
                                presence = lesson.presence,
                                lessonTheme = lesson.theme,
                                teacherName = lesson.teacher,
                                currentBall = null,
                                pref = pref
                            )
                        }
                    }
                    2 -> {
                        item {
                            lessonCard(
                                cardType = lesson.type.toInt(),
                                lessonName = "Экзамен",
                                lessonDate = lesson.date,
                                presence = lesson.presence,
                                teacherName = lesson.teacher,
                                lessonTheme = lesson.theme,
                                currentBall = group.students[1].lessons[3].currentBall,
                                pref = pref
                            )
                        }
                    }
                }

            }

        }
    }
}