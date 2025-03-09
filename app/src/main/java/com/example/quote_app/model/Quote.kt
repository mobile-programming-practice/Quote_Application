package com.example.quote_app.model

// Define the quote model based on the structure of the API response
data class Quote(
    val quote: String,
    val author: String
)
//data class gor api response
data class QuoteResponse(
    val quotes: List<Quote>
)