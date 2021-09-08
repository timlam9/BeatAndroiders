package com.timlam.beatandroiders.presentation.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TestRemember() {
//    var number = 0
    var number: Int = remember { 0 }
//    var number = mutableStateOf(0)
//    var number by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                Log.d("TAGARA", "Number: $number")
                number++
            },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Red
            )
        ) {
            Text("Button")
        }
        Text(text = "Number: $number")
    }
}
