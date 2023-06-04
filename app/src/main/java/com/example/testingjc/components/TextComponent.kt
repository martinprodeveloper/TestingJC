package com.example.testingjc.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun TextComponent() {

    var name by rememberSaveable { mutableStateOf("Martin") }

    Column(Modifier.fillMaxSize()) {
        //Text(text = "MARTIN", modifier = Modifier.testTag("text1"))
        //Text(text = "MARTIN", modifier = Modifier.testTag("text2"))
        //Image(imageVector = Icons.Default.Add, contentDescription = "image1")

        TextField(value = name, onValueChange = { name = it }, modifier = Modifier.testTag("textFieldName"))
        Text(text = "Te llamas $name", modifier = Modifier.testTag("textGreeting"))
    }
}