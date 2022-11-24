package com.example.begunok_hakaton

import android.content.SharedPreferences
import android.util.Log
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.begunok_hakaton.dataclasses.GroupDataClasses.Group
import com.example.begunok_hakaton.dataclasses.StudentDataClasses.Student
import com.google.gson.Gson

@Composable
fun RunnerScreen(student: Student, pref: SharedPreferences, NavOnBack: () -> Unit) {
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
    Column() {
        TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "", modifier = Modifier.clickable {
                    NavOnBack()
                })
            }
            Text("", fontSize = 22.sp)
        }
        val pointsLine = remember { mutableStateOf("") }
        var date by remember { mutableStateOf("25.11.2022") }
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
        Text(
            text = "Бегунок",
            fontSize = 18.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF728394),
            modifier = Modifier.padding(start = 20.dp)
        )
        Text(
            text = student.fio,
            fontSize = 36.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
            modifier = Modifier.padding(start = 20.dp)

        )
        Text(
            text = "Студент 3 курса группы Б760,\nФКНТ",
            fontSize = 18.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF728394),
            modifier = Modifier.padding(start = 20.dp)
        )
        //Spacer()
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Дата аттестации",
            fontSize = 18.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
            modifier = Modifier.padding(start = 20.dp)
        )

        //var text = "24.12.2021"
        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            //fontStyle = FontStyle()
            textStyle = TextStyle(
                color = Color(0xFF535C64),
                fontSize = 20.sp,
                fontWeight = FontWeight(400)
            ),
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            //modifier = Modifier.height(1.dp),
            readOnly = true,
            trailingIcon = if (date.isNotBlank()) trailingIconView else null,
        )

        Text(
            text = "Оценка",
            fontSize = 18.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
            modifier = Modifier.padding(start = 20.dp, top = 30.dp)
        )

        //var text = "24.12.2021"
        OutlinedTextField(
            value = pointsLine.value,
            onValueChange = { letter ->
                pointsLine.value = letter
            },
            //fontStyle = FontStyle()
            textStyle = TextStyle(
                color = Color(0xFF535C64),
                fontSize = 20.sp,
                fontWeight = FontWeight(400)
            ),
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            //modifier = Modifier.height(1.dp),
            //readOnly = true,
            //trailingIcon = if (date.isNotBlank()) trailingIconView else null,
        )
        Row(modifier = Modifier.padding(start = 20.dp, top = 15.dp)) {
            Column(Modifier.weight(0.8f)) {
                Text(
                    text = "Максимальный балл:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF728394),
                    //modifier = Modifier.padding(start = 20.dp,top = 15.dp)
                )
            }
            Column(Modifier.weight(0.2f)) {
                //Box(contentAlignment = Alignment.CenterEnd){
                Text(
                    text = "72.00",
                    //textAlign = TextAlign.Right,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    //modifier = Modifier.padding(start = 20.dp,top = 15.dp)
                )
                //}

            }
        }
        Spacer(modifier = Modifier.height(90.dp))
        Button(
            onClick = {
                if (pointsLine.value != "") {
                    val group: Group = Gson().fromJson(pref.getString("data",""), Group::class.java)
                    group.students[1].lessons[3].currentBall = pointsLine.value
                    Log.d("date",date)
                    group.students[1].lessons[3].date = date
                    group.students[1].active_arrears = null
                    pref.edit().putString("data",Gson().toJson(group)).apply()
                    NavOnBack()
                }
            },
            Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .height(55.dp),
            colors = buttonColors(backgroundColor = Color(0xFF008296)),
            border = BorderStroke(1.dp, Color(0xFF3B6275)),
            //modifier = Modifier.height(100.dp)
        ) {
            Text(
                text = "Подтвердить",
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF)
            )
        }

    }
}