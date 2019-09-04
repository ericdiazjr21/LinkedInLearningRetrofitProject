package ericdiaz.program.linkedinlearningretrofitproject.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {

    private const val BASE_URL = "http://api.github.com"

    private val singletonRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val gitHubService: GithubService = singletonRetrofit.create(GithubService::class.java)
}