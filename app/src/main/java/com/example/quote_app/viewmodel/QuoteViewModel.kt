package com.example.quote_app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.quote_app.model.QuoteResponse
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//defining api interface
interface QuotesApi {
    @GET("quotes")
    //api returns a list of quotes
    suspend fun getQuotes(): QuoteResponse
}

//implementing ViewModel
class QuoteViewModel : ViewModel() {
    //to hold current quote to display
    var currentQuote: String by mutableStateOf("Fetching quote...")
    var errorMessage: String? by mutableStateOf(null)


    //initializing retrofit and quotesApi instance
    private val quotesApi: QuotesApi = Retrofit.Builder()
        //url for api
        .baseUrl("https://dummyjson.com/")
        //use gson to convert json res
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(QuotesApi::class.java)

    init {
        //fetch random quote when the ViewModel create
        fetchRandomQuote()
    }

    //fun to fetch a random quote
    fun fetchRandomQuote() {
        viewModelScope.launch {
            try {
                //fetch data from api
                val quoteResponse = quotesApi.getQuotes()

                // Process the response
                if (quoteResponse.quotes.isNotEmpty()) {
                    //random quote from the list
                    val quote = quoteResponse.quotes.random()
                    currentQuote = "\"${quote.quote}\"\n \n— ${quote.author}"
                } else {
                    currentQuote = "No quotes found."
                }
            } catch (e: Exception) {
                //if err occurs log the err
                Log.e("QuoteViewModel", "Error fetching quote: ${e.message}")
                //set err msg to notify the user
                errorMessage = "Failed to fetch quote. Please check your connection."

            }
        }
    }
}
