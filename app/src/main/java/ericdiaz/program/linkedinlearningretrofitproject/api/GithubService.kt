package ericdiaz.program.linkedinlearningretrofitproject.api

import ericdiaz.program.linkedinlearningretrofitproject.model.Gist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    /**
     * Return public gists from api
     */
    @GET("gists/public")
    fun getPublicGists(): Call<List<Gist>>

    /**
     * Return users gists from api
     */
    @GET("gists")
    fun getUserGists(): Call<List<Gist>>

    /**
     * Return starred gists from api
     */
    @GET("gists/starred")
    fun getStarredGists(): Call<List<Gist>>

    @GET("gists/{gistId}")
    fun getGist(@Path("gistId") gistId: String): Call<Gist>
}