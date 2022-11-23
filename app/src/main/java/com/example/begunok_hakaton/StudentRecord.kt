package com.example.begunok_hakaton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                AcademicRecord("Основы программной инженерии")
            }
        }
    }
}

@Composable
fun AcademicRecord(pageDescription: String) {

    Column() {
        TopAppBar {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Menu, contentDescription = pageDescription)
            }
            Text("Программирование", fontSize = 22.sp)
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Info, contentDescription = "Информация о приложении")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Search, contentDescription = "Поиск")
            }
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            for (i in 0..10) {
                item {
                    lessonCard(
                        lessonName = "Lesson$i",
                        date = "date$i",
                        controlTask = controlTask(
                            theme = "Control Task Theme $i",
                            maxPoint = "${i + 10}",
                            currentPoint = "$i",
                            isQuestIssued = i % 2 == 0
                        ),
                        presence = i % 2 == 0,
                        lessonTheme = "LessonTheme$i",
                        teacherName = "TeacherName$i"
                    )
                }
            }
        }
    }
}


@Composable
fun lessonCard(
    lessonName: String?,
    date: String?,
    controlTask: controlTask,
    presence: Boolean?,
    lessonTheme: String?,
    teacherName: String?
) {
    val lessonNameWeight = FontWeight(450)
    val lessonNameModifier = Modifier.padding(top = 3.dp, bottom = 3.dp)
    val dataTextWeight = FontWeight(400)
    val dataTextModifier = Modifier.padding(start = 5.dp, bottom = 4.dp)
    val dataSecondTextModifier = dataTextModifier.padding(start = 0.dp, end = 5.dp)

    Column() {
        Row() {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 5.dp),
                backgroundColor = Color(0x26007D8A),
                shape = RoundedCornerShape(topEnd = 10.dp),
            ) {
                Box(contentAlignment = Alignment.CenterStart) {
                    if (lessonName != null) Text(
                        text = lessonName,
                        fontSize = 20.sp,
                        fontWeight = lessonNameWeight,
                        modifier = lessonNameModifier,
                    )
                    else Text("Название занятия не назначено")
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.weight(1f))
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp),
            backgroundColor = Color(0xBFF6D5C9)
        ) {
            Row(Modifier.padding(vertical = 5.dp)) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f),
                ) {
                    if (date != null) Text(
                        "Дата:",
                        fontWeight = dataTextWeight,
                        modifier = dataTextModifier
                    )
                    else Text(
                        "Дата не назначена",
                        fontWeight = dataTextWeight,
                        modifier = dataTextModifier
                    )
                    Text("Посещение:", fontWeight = dataTextWeight, modifier = dataTextModifier)
                    if (lessonTheme != null) Text(
                        "Тема занятия: ",
                        fontWeight = dataTextWeight,
                        modifier = dataTextModifier,
                        textAlign = TextAlign.Right
                    )
                    else Text(
                        "Тема не назначена",
                        fontWeight = dataTextWeight,
                        modifier = dataTextModifier
                    )

                    if (teacherName != null) Text(
                        "Преподаватель: ",
                        fontWeight = dataTextWeight,
                        modifier = dataTextModifier
                    )
                    else Text(
                        "Преподаватель не назначен",
                        fontWeight = dataTextWeight,
                        modifier = dataTextModifier
                    )

                    if (controlTask.isQuestIssued) Text(
                        "Контрольное испытание:",
                        fontWeight = dataTextWeight,
                        modifier = dataTextModifier
                    )
                }
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    if (date != null) Text(
                        date,
                        fontWeight = dataTextWeight,
                        modifier = dataSecondTextModifier
                    )
                    else Text("", fontWeight = dataTextWeight, modifier = dataSecondTextModifier)

                    if (presence == null) Text(
                        "",
                        fontWeight = dataTextWeight,
                        modifier = dataSecondTextModifier
                    )
                    else if (!presence) Text(
                        "Отсутствовал",
                        fontWeight = dataTextWeight,
                        modifier = dataSecondTextModifier
                    )
                    else Text(
                        "Присутствовал",
                        fontWeight = dataTextWeight,
                        modifier = dataSecondTextModifier
                    )

                    if (lessonTheme != null) Text(
                        lessonTheme,
                        fontWeight = dataTextWeight,
                        modifier = dataSecondTextModifier
                    )
                    else Text("", fontWeight = dataTextWeight, modifier = dataSecondTextModifier)

                    if (teacherName != null) Text(
                        teacherName,
                        fontWeight = dataTextWeight,
                        modifier = dataSecondTextModifier
                    )
                    else Text("", fontWeight = dataTextWeight, modifier = dataSecondTextModifier)

                    if (controlTask.isQuestIssued) {
                        Text(
                            "${controlTask.theme}\n(МБ:${controlTask.maxPoint}) - ${controlTask.currentPoint}",
                            fontWeight = dataTextWeight,
                            modifier = dataSecondTextModifier
                        )
                    }
                }
            }
        }
    }
}

