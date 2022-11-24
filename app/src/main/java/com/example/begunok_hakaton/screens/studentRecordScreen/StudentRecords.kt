package com.example.begunok_hakaton.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StudentRecord(
    lessonName: String?, yearOfStudy: String?, onNavToNext: () -> Unit = {}
) {
    Column() {
        TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Menu, contentDescription = "")
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
            for (i in 0..10) {
                item {
                    lessonCard(
                        cardType = 1,
                        lessonName = "Лекция $i",
                        lessonDate = "25.01.2022",
                        presence = i % 2 == 0,
                        lessonTheme = "Основы алгоритмизации:$i",
                        teacherName = "Жамбалов Э.Б.",
                    )
                }
            }
            item {
                lessonCard(
                    cardType = 2,
                    lessonName = "Аттестация",
                    lessonDate = "25.12.2022",
                    presence = true,
                    teacherName = "Жамбалов Э.Б.",
                    lessonTheme = null,
                )
            }
        }
    }
}