package com.example.quote_app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun InfoScreen(navController: NavController, modifier: Modifier = Modifier) {
    //column to hold the text and button
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        //info text
        Text(text = "This is a simple random quote generator app. Tap 'Next' to get a new quote!")

        //button to go back to Home Screen
        Button(onClick = {
            navController.navigate("home") //navigate back to HomeScreen
        }) {
            Text("Go Home")
        }
    }
}
