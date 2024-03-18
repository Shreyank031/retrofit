package com.shrey.retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get an instance of the QuotesAPI interface from RetrofitHelper
        val quotesAPI = RetrofitHelper.getInstance().create(QuotesAPI::class.java)

        // Coroutine for making a network request in a background thread
        GlobalScope.launch {
            // Make a network call to fetch quotes
            val result = quotesAPI.getQuotes(1)
            if (result != null) {
                // Extract the list of quotes from the response
                val quoteList = result.body()

                // Iterate over each quote and log its content
                quoteList!!.results.forEach {
                    Log.d("JacksonDp", it.content)
                }

                // Log the entire response body
                Log.d("JacksonDD", result.body().toString())
            }
        }
    }
}
