package com.example.restapiapp.presintation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.restapiapp.ui.theme.RestApiAppTheme

@Composable
fun MainScreen (){
    Column() {
        Text(text = "RestApiAppTheme")
        
    }
    
}


@Preview(showBackground = true)
@Composable
fun GreetingPPreview(){
    RestApiAppTheme {
        MainScreen()
    }
}
