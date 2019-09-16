package ericdiaz.program.linkedinlearningretrofitproject.api

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor(userName: String, accessToken: String) : Interceptor {

    private var credentials: String = Credentials.basic(userName, accessToken)

    override fun intercept(chain: Interceptor.Chain): Response {

        val authRequest = chain.request()
            .newBuilder()
            .header("Authorization", credentials)
            .build()

        return chain.proceed(authRequest)
    }
}