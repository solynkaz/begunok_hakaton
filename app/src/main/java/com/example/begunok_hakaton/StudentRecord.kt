package com.example.begunok_hakaton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = Color.Transparent
            )
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
            AcademicRecord("Основы программной инженерии", "Программирование", "2022")
        }
    }
}

@Composable
fun AcademicRecord(
    pageDescription: String, lessonName: String?, yearOfStudy: String?,
) {
    Column() {
        TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Menu, contentDescription = pageDescription)
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


@Composable
fun lessonCard(
    cardType: Int,
    lessonName: String?,
    lessonDate: String?,
    presence: Boolean?,
    lessonTheme: String?,
    teacherName: String?,
) {
    val fontTitle = 20.sp
    val fontSubTitle = 18.sp
    val weightSubTitle = FontWeight(400)
    val modifierTitle = Modifier.padding(top = 7.dp, start = 5.dp)
    when (cardType) {
        1 -> {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(bottom = 10.dp)
            ) {
                Card(
                    modifier = Modifier.padding(horizontal = 7.dp),
                    border = BorderStroke((0.15).dp, Color(0x80000000)),
                    backgroundColor = Color(0xCCFFFFFF),
                    elevation = 0.dp
                ) {
                    Column(
                        modifier = Modifier
                            .weight(2f)
                            .padding(start = 7.dp, end = 7.dp),
                    ) {
                        Row(Modifier.fillMaxWidth()) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .weight(1f)
                            ) {
                                if (lessonName != null) {
                                    Text(
                                        text = lessonName,
                                        fontSize = fontTitle,
                                        fontWeight = weightSubTitle,
                                        modifier = modifierTitle.align(Alignment.CenterStart)
                                    )
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                if (lessonDate != null) {
                                    Text(
                                        text = lessonDate,
                                        color = Color(0xA6000000),
                                        fontSize = fontSubTitle,
                                        fontWeight = weightSubTitle,
                                        modifier = modifierTitle
                                            .padding(top = 0.dp)
                                            .align(Alignment.CenterEnd)
                                    )
                                }
                            }
                        }
                        Row() {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text(
                                    "Посещение",
                                    fontSize = fontSubTitle,
                                    fontWeight = weightSubTitle,
                                    modifier = modifierTitle
                                        .padding(top = 4.dp)
                                        .align(Alignment.CenterStart)
                                )
                            }
                            if (presence != null) {
                                if (presence) {
                                    Text(
                                        "+",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight(450),
                                        modifier = modifierTitle.padding(end = 10.dp),
                                        color = Color(0xFF5ACC00)
                                    )
                                } else {
                                    Text(
                                        "-",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight(450),
                                        modifier = modifierTitle.padding(end = 10.dp),
                                        color = Color(0xFFCC0000)
                                    )
                                }
                            }
                        }
                        Row(Modifier.padding(top = 7.dp)) {
                            Column() {
                                Text(
                                    "Тема занятия",
                                    fontSize = fontSubTitle,
                                    fontWeight = weightSubTitle,
                                    modifier = Modifier.padding(start = 5.dp)
                                )
                                if (lessonTheme != null) Text(
                                    lessonTheme,
                                    modifier = Modifier.padding(start = 5.dp, bottom = 8.dp),
                                    color = Color(0xA6000000),
                                    fontSize = 12.sp,
                                    fontWeight = weightSubTitle
                                )
                            }
                        }
                        Row(Modifier.padding(bottom = 7.dp)) {
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                if (teacherName != null) {
                                    Text(
                                        text = "Преподаватель",
                                        fontSize = fontSubTitle,
                                        fontWeight = weightSubTitle,
                                        modifier = modifierTitle
                                    )
                                }
                            }
                            if (teacherName != null) {
                                Text(
                                    text = teacherName,
                                    fontSize = fontSubTitle,
                                    fontWeight = weightSubTitle,
                                    modifier = modifierTitle.padding(bottom = 10.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
        2 -> {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(bottom = 7.dp)
            ) {
                Card(
                    modifier = Modifier.padding(horizontal = 7.dp),
                    border = BorderStroke((0.15).dp, Color(0x80000000)),
                    elevation = 0.dp,
                    backgroundColor = Color(0xCCFFFFFF),
                ) {
                    Column(
                        modifier = Modifier
                            .weight(2f)
                            .padding(start = 7.dp, end = 7.dp),
                    ) {
                        Row(Modifier.fillMaxWidth()) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .weight(1f)
                            ) {
                                if (lessonName != null) {
                                    Text(
                                        text = lessonName,
                                        fontSize = fontTitle,
                                        fontWeight = weightSubTitle,
                                        modifier = modifierTitle.align(Alignment.CenterStart)
                                    )
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                if (lessonDate != null) {
                                    Text(
                                        text = lessonDate,
                                        color = Color(0xA6000000),
                                        fontSize = fontSubTitle,
                                        fontWeight = weightSubTitle,
                                        modifier = modifierTitle
                                            .padding(top = 0.dp)
                                            .align(Alignment.CenterEnd)
                                    )
                                }
                            }
                        }
                        Row() {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text(
                                    "Посещение",
                                    fontSize = fontSubTitle,
                                    fontWeight = weightSubTitle,
                                    modifier = modifierTitle
                                        .padding(top = 4.dp)
                                        .align(Alignment.CenterStart)
                                )
                            }
                            if (presence != null) {
                                if (presence) {
                                    Text(
                                        "+",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight(450),
                                        modifier = modifierTitle.padding(end = 10.dp),
                                        color = Color(0xFF5ACC00)
                                    )
                                } else {
                                    Text(
                                        "-",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight(450),
                                        modifier = modifierTitle.padding(end = 10.dp),
                                        color = Color(0xFFCC0000)
                                    )
                                }
                            }
                        }
                        Row(Modifier.padding(top = 7.dp)) {
                            Text(
                                "Экзамен (МБ:48) - 0.0",
                                fontSize = fontSubTitle,
                                fontWeight = weightSubTitle,
                                modifier = Modifier.padding(start = 5.dp)
                            )
                        }
                        Row(Modifier.padding(top = 7.dp)) {
                        }
                        Row(Modifier.padding(bottom = 7.dp)) {
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .weight(1f)) {
                                if (teacherName != null) {
                                    Text(
                                        text = "Преподаватель",
                                        fontSize = fontSubTitle,
                                        fontWeight = weightSubTitle,
                                        modifier = modifierTitle.align(Alignment.CenterStart)
                                    )
                                }
                            }
                            if (teacherName != null) {
                                Text(
                                    text = teacherName,
                                    fontSize = fontSubTitle,
                                    fontWeight = weightSubTitle,
                                    modifier = modifierTitle
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

