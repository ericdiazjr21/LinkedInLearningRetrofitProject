package ericdiaz.program.linkedinlearningretrofitproject.api

import ericdiaz.program.linkedinlearningretrofitproject.model.Gist
import ericdiaz.program.linkedinlearningretrofitproject.model.GistComment
import ericdiaz.program.linkedinlearningretrofitproject.model.GitHubUser
import retrofit2.Call
import retrofit2.http.*

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

    /**
     * Return a Single Gist
     */
    @GET("gists/{gistId}")
    fun getGist(@Path("gistId") gistId: String): Call<Gist>

    /**
     * Return comments for a particular Gist provided by Id
     */
    @GET("gists/{gistId}/comments")
    fun getGistCommentsById(
        @Path("gistId") gistId: String,
        @Query("page") pageNumber: Int
    ): Call<List<GistComment>>

    /**
     * This method uses the head annotation which means that no body is required
     * and is expected when you are making the call. This is why the return type
     * inside of the call is of type Unit.
     */
    @HEAD("gists/{gistId}/comments")
    fun getGistCommentHeadersById(@Path("gistId") gistId: String): Call<Void>


    @GET("user")
    fun getLoggedInUser(@Header("Authorization") auth: String): Call<GitHubUser>
}