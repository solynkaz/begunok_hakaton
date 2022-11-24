package com.example.begunok_hakaton.screens.mainMenu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.begunok_hakaton.R

@Composable
fun mainMenu(onNavToStudent: () -> Unit = {}, onNavToTeacher: () -> Unit = {}) {
    val buttonModifier = Modifier
        .fillMaxWidth()
        .height(58.dp)
        .padding(start = 2.dp, top = 15.dp)
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
    Column(Modifier.padding()) {
        Spacer(Modifier.weight(2f))
        Button(
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp
            ),
            border = BorderStroke((0.5).dp,Color(0xA6000000)),

            enabled = true,
            modifier = buttonModifier
                .weight(1f)
                .padding(start = 3.dp, end = 5.dp)
                .fillMaxWidth()
                .weight(1f),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xD9FFFFFF),
                contentColor = Color.Black.copy(alpha = 0.8f),
            ),
            contentPadding = PaddingValues(0.dp),
            onClick = {
                onNavToStudent()
            }
        ) {
            Text(
                "Студент", fontSize = 25.sp, fontWeight = FontWeight(550)
            )
        }
        Button(
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp
            ),
            border = BorderStroke((0.5).dp,Color(0xA6000000)),
            enabled = true,
            modifier = buttonModifier
                .weight(1f)
                .padding(start = 3.dp, end = 5.dp)
                .fillMaxWidth()
                .weight(1f),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xD9FFFFFF),
                contentColor = Color.Black.copy(alpha = 0.8f),
            ),
            contentPadding = PaddingValues(0.dp),
            onClick = {
                onNavToTeacher()
            }
        ) {
            Text(
                "Преподаватель", fontSize = 25.sp, fontWeight = FontWeight(550)
            )
        }
        Spacer(Modifier.weight(2f))
    }
}
