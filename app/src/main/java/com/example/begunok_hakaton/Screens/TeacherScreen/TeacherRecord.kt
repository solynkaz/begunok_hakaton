package com.example.begunok_hakaton.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TeacherRecord() {

    Column() {
        TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Menu, contentDescription = "")
            }
            Text("", fontSize = 22.sp)
        }
        Text(
            text = "Журнал",
            fontSize = 18.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF728394),
            modifier = Modifier.padding(start = 20.dp)
        )
        Text(
            text = "Программирование",
            fontSize = 36.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
            modifier = Modifier.padding(start = 20.dp)

        )

        var text by remember { mutableStateOf("24.12.2021") }
        val trailingIconView = @Composable {
            IconButton(
                onClick = {
                    //text = ""
                },
            ) {
                Icon(
                    Icons.Default.DateRange,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        }
        //var text = "24.12.2021"
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            //fontStyle = FontStyle()
            textStyle = androidx.compose.ui.text.TextStyle(
                color = Color(0xFF535C64),
                fontSize = 20.sp,
                fontWeight = FontWeight(400)
            ),
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            //modifier = Modifier.height(1.dp),
            readOnly = true,
            trailingIcon = if (text.isNotBlank()) trailingIconView else null,
        )
        Text(
            text = "Аттестация",
            fontSize = 14.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF728394),
            modifier = Modifier.padding(start = 20.dp)
        )
        Text(
            text = "Экзамен",
            fontSize = 24.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
            modifier = Modifier.padding(start = 20.dp)
        )
        Row() {
            Column(Modifier.weight(0.245f)) {
                //icon
            }
            Column(Modifier.weight(0.85f)) {
                Text(
                    text = "Группа Б760",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
                Text(
                    text = "подгруппа 1",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF728394),
                )
            }


        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            for (i in 0..10) {
                item {
                    studentCard(
                        studentFio = "Фамилия Имя \nОтчество $i",
                        studentPoints = "00.00",
                        maxPoints = "72.00",
                        studentStatus = (1..3).random()
                    )
                }
            }
        }
    }
}

    @Composable
    fun studentCard(
        studentFio: String,
        studentPoints: String,
        maxPoints: String,
        studentStatus: Int,
    ) {
        val studentFioWeight = FontWeight(600)

        val studentPointsWeight = FontWeight(600)
        Row(modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)) {
            Column(Modifier.weight(0.2f)) {
                //icon
            }
            Column(Modifier.weight(0.5f)) {
                if (studentFio != null) Text(
                    text = studentFio,
                    fontSize = 18.sp,
                    fontWeight = studentFioWeight,
                )
                else Text("ФИО")
                //1 - Аттестован
                //2 - Не аттестован
                //3 - Бегунок
                when (studentStatus) {
                    1 -> {
                        Text(
                            text = "Аттестован",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF008296)
                        )
                    }
                    2 -> {
                        Text(
                            text = "Не аттестован",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFFF05523)
                        )
                    }
                    3 -> {
                        Text(
                            text = "Бегунок",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF728394)
                        )
                    }
                }
            }
            Column(
                Modifier
                    .weight(0.3f)
                    .align(CenterVertically)
            ) {
                if (studentPoints != null) Text(
                    text = "$studentPoints/$maxPoints",
                    fontSize = 18.sp,
                    fontWeight = studentPointsWeight,
                    // modifier = studentPointsModifier,
                    textAlign = TextAlign.Center
                )
                else Text("00.00")
                Text(
                    text = "Баллы итог.",
                    textAlign = TextAlign.Right,
                    fontSize = 14.sp,
                    color = Color(0xFF728394),
                    fontWeight = FontWeight(600)
                )
            }
        }
}