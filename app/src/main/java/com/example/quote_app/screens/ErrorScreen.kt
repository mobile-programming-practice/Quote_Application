package com.example.quote_app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quote_app.viewmodel.QuoteViewModel

//fun to display err screen
@Composable
fun ErrorScreen(errorMessage: String, viewModel: QuoteViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //txt to show err msg
        Text(text = "Something went wrong!", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        //show dynamic error msg
        Text(text = errorMessage)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.fetchRandomQuote() }) {
            Text(text = "Retry")
        }
    }
}
