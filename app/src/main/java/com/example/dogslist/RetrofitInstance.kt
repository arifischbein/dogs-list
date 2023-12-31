package com.example.dogslist

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* This class is used to create a singleton of the Retrofit instance.
* If dependency injection is used, this class is not needed and the Retrofit instance can be injected directly into di classes.
*/
object RetrofitInstance {
    val api: APIService by lazy {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}
