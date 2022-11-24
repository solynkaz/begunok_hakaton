package com.example.begunok_hakaton.screens


import android.content.SharedPreferences
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.begunok_hakaton.R
import com.example.begunok_hakaton.dataclasses.GroupDataClasses.Group
import com.example.begunok_hakaton.dataclasses.StudentDataClasses.Student
import com.google.gson.Gson


@Composable
fun TeacherRecord(group1: Group, onNavToCard: (student: Student) -> Unit, pref: SharedPreferences,
NavOnBack: () -> Unit) {
    val group: Group = Gson().fromJson(pref.getString("data",""), Group::class.java)
    Row(
        Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = CenterVertically
    ) {
        Image(
            painterResource(id = R.drawable.group_174asd),
            contentDescription = "",
            alignment = Alignment.Center,
            alpha = 0.4f
        )
    }
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
            text = "Журнал",
            fontSize = 18.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF728394),
            modifier = Modifier.padding(start = 15.dp)
        )
        Text(
            text = "Программирование",
            fontSize = 36.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
            modifier = Modifier.padding(start = 15.dp)

        )

        var text by remember { mutableStateOf("20.12.2022") }
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
                .padding(start = 15.dp, end = 20.dp)
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
            modifier = Modifier.padding(start = 15.dp)
        )
        Text(
            text = "Экзамен",
            fontSize = 24.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
            modifier = Modifier.padding(start = 15.dp)
        )
        Row(Modifier.padding(bottom = 24.dp)) {
            Column(
                Modifier
                    .weight(0.245f)
                    .padding(start = 10.dp)
            ) {
                //icon
                Image(
                    painterResource(id = R.drawable.group),
                    contentDescription = "",
                    alignment = Alignment.Center,
                    //alpha = 0.4f
                )
            }
            Column(Modifier.weight(0.85f)) {
                Log.d("TeacherRecord", group.toString())
                Text(
                    text = group.groupName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(top = 5.dp),
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
            for (student in group.students) {
                val studentName = student.fio.split(" ")
                val group: Group = Gson().fromJson(pref.getString("data", ""), Group::class.java)
                val status: Int = if (student.active_arrears == null) {
                    1
                } else if ((group.students[1].active_arrears != null) && !group.students[1].active_arrears!![0].arrearSended) {
                    2
                } else {
                    3
                }
                item {
                    studentCard(
                        student = student,
                        studentFio = "${studentName[0]} ${studentName[1]}\n${studentName[2]}",
                        studentPoints = student.lessons[3].currentBall.toString(),
                        maxPoints = "72.00",
                        studentStatus = status,
                        onNavToCard = onNavToCard
                    )
                }
            }
        }
    }
}

@Composable
fun studentCard(
    student: Student,
    studentFio: String,
    studentPoints: String,
    maxPoints: String,
    studentStatus: Int,
    onNavToCard: (student1: Student) -> Unit = {}
) {
    val studentFioWeight = FontWeight(600)

    val studentPointsWeight = FontWeight(600)
    val cardModifierClickable =
        if (studentStatus == 3) Modifier.clickable { onNavToCard(student) }
        else Modifier

    Row(
        modifier = cardModifierClickable.padding(bottom = 10.dp, start = 10.dp)
    ) {
        var studentStatusTemp = studentStatus
            Column(Modifier.weight(0.2f)) {
                //1 - Аттестован
                //2 - Не аттестован
                //3 - Бегунок
                when (studentStatus) {
                    1 -> {
                        Image(
                            painterResource(id = R.drawable.check_mark),
                            contentDescription = "",
                            alignment = Alignment.Center,
                            modifier = Modifier.padding(top = 5.dp)
                            //alpha = 0.4f
                        )
                    }
                    2 -> {
                        Image(
                            painterResource(id = R.drawable.warn),
                            contentDescription = "",
                            alignment = Alignment.Center,
                            modifier = Modifier.padding(top = 5.dp)
                            //alpha = 0.4f
                        )
                    }
                    3 -> {
                        Image(
                            painterResource(id = R.drawable.runner),
                            contentDescription = "",
                            alignment = Alignment.Center,
                            modifier = Modifier.padding(top = 5.dp)
                            //alpha = 0.4f
                        )
                    }
                }

            }
        Column(Modifier.weight(0.5f)) {
            if (studentFio != null) Text(
                text = studentFio,
                fontSize = 18.sp,
                fontWeight = studentFioWeight,
            )
            else Text("ФИО")

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