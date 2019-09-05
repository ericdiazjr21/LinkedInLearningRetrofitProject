package ericdiaz.program.linkedinlearningretrofitproject.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Retrofit singleton pattern in Kotlin. Notice that the class declaration is
// object which means that the RetrofitSingleton class will be treated as a singleton by the KT compiler.
// The base url has the private access modifier because by default variables are set to public
// when created without an access modifier. The singletonRetrofit is also private because no other
// class will need this, only the service that's being created needs to know about the
// singletonRetrofit. The gitHubService has no access modifier and is a 'val' which means that by
// default it is public and it's value cannot be modified. Also note, it will be the only
// instance created when the field is accessed since the class has the object declaration.
// No matter how many times it is accessed it will always have the same value. In other words,
// its a singleton service.
object RetrofitSingleton {

    private const val BASE_URL = "http://api.github.com"

    private val singletonRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val gitHubService: GithubService = singletonRetrofit.create(GithubService::class.java)
}