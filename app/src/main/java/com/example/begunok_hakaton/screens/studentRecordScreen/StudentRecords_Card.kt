package com.example.begunok_hakaton.screens

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.begunok_hakaton.dataclasses.GroupDataClasses.Group
import com.google.gson.Gson


@Composable
fun lessonCard(
    cardType: Int,
    lessonName: String?,
    lessonDate: String?,
    presence: Boolean?,
    lessonTheme: String?,
    teacherName: String?,
    currentBall: String?,
    pref: SharedPreferences
) {
    val group: Group = Gson().fromJson(pref.getString("data", ""), Group::class.java)
    val fontTitle = 20.sp
    val fontSubTitle = 18.sp
    val weightSubTitle = FontWeight(400)
    val modifierTitle = Modifier.padding(top = 7.dp, start = 5.dp)
    val openDialog = remember { mutableStateOf(false) }
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
                                    fontSize = fontSubTitle,
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
            val cardModifier =
                if ((group.students[1].active_arrears != null) && group.students[1].lessons[3].currentBall == "0" && !group.students[1].active_arrears!![0].arrearSended) Modifier.clickable { openDialog.value = true }
                else Modifier
            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = { openDialog.value = false },
                    title = {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                            //Text("Подтверждение действия")
                        }
                    },
                    text = {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                            Text("Подать заявку на бегунок?", fontSize = 18.sp)
                        }
                    },
                    buttons = {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Button(
                                elevation = ButtonDefaults.elevation(
                                    defaultElevation = 0.dp,
                                    pressedElevation = 0.dp,
                                    disabledElevation = 0.dp
                                ),
                                modifier = Modifier.padding(horizontal = 10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Transparent,
                                    contentColor = Color.Black,
                                ),
                                onClick = {
                                    val string = pref.getString("data", "NOVALUE")
                                    val group: Group = Gson().fromJson(
                                        pref.getString("data", ""),
                                        Group::class.java
                                    )
                                    group.students[1].active_arrears!![0].arrearSended = true
                                    pref.edit().putString("data", Gson().toJson(group)).apply()
                                    Log.d("data", string.toString())
                                    openDialog.value = false
                                },
                            )
                            { Text("Да", fontSize = 16.sp, fontWeight = FontWeight(400)) }
                            Button(
                                elevation = ButtonDefaults.elevation(
                                    defaultElevation = 0.dp,
                                    pressedElevation = 0.dp,
                                    disabledElevation = 0.dp
                                ),
                                onClick = { openDialog.value = false },
                                modifier = Modifier.padding(horizontal = 10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Transparent,
                                    contentColor = Color.Black
                                )
                            ) { Text("Нет", fontSize = 16.sp, fontWeight = FontWeight(400)) }
                        }
                    }
                )
            }
            Column(
                modifier = cardModifier
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
                                    group.students[1].lessons[3].date?.let {
                                        Text(
                                            text = it,
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
                                "Экзамен (МБ:72) - $currentBall",
                                fontSize = fontSubTitle,
                                fontWeight = weightSubTitle,
                                modifier = Modifier.padding(start = 5.dp)
                            )
                        }
                        Row(Modifier.padding(top = 7.dp)) {

                            Text(
                                "Результат",
                                fontSize = fontSubTitle,
                                fontWeight = weightSubTitle,
                                modifier = Modifier.padding(start = 5.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                Text(
                                    text = if ((group.students[1].active_arrears != null) && group.students[1].active_arrears!![0].arrearSended) "Заявка отправлена"
                                            else if ((group.students[1].active_arrears != null) && group.students[1].active_arrears!![0] != null) "Не аттестован"
                                            else "Аттестован",
                                            //text = if (currentBall!!.toInt() > 0) "Аттестован"
                                            //else "Не аттестован",
                                            fontSize = fontSubTitle,
                                    fontWeight = weightSubTitle,
                                    modifier = Modifier
                                        .padding(start = 5.dp)
                                        .align(Alignment.CenterEnd)
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