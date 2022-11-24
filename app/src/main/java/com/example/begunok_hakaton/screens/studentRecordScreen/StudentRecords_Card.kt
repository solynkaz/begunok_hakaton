package com.example.begunok_hakaton.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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
        } //Лекция/практика
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
                                    .weight(1f)
                            ) {
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
        } //Экзамен
    }
}