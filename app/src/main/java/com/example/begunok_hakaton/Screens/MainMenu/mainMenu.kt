package com.example.begunok_hakaton.Screens.MainMenu

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
import androidx.compose.ui.unit.dp
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
    Row(){
        Button(
            enabled = true,
            modifier = buttonModifier
                .weight(1f)
                .padding(start = 4.dp, end = 3.dp)
                .fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.LightGray,
            ),
            contentPadding = PaddingValues(0.dp),
            onClick = {
                onNavToStudent()
            }
        ) {
            Text(
                "Студент"
            )
        }
        Button(
            enabled = true,
            modifier = buttonModifier
                .weight(1f)
                .padding(start = 4.dp, end = 3.dp)
                .fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.LightGray,
            ),
            contentPadding = PaddingValues(0.dp),
            onClick = {
                onNavToTeacher()
            }
        ) {
            Text(
                "Препод"
            )
        }
    }
}
