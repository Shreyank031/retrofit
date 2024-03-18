package com.shrey.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// https://quotable.io/quotes?page=1
interface QuotesAPI {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>
    //Done with the interface, time for Retrofit object
}