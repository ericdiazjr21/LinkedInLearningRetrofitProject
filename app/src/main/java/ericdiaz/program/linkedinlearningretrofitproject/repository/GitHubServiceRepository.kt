package ericdiaz.program.linkedinlearningretrofitproject.repository

import ericdiaz.program.linkedinlearningretrofitproject.api.GithubService
import ericdiaz.program.linkedinlearningretrofitproject.callback.*
import ericdiaz.program.linkedinlearningretrofitproject.model.Gist
import ericdiaz.program.linkedinlearningretrofitproject.model.GistComment
import ericdiaz.program.linkedinlearningretrofitproject.model.GitHubUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitHubServiceRepository constructor(
    private val githubService: GithubService
) {

    fun getPublicGists(
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        githubService.getPublicGists().enqueue(object : Callback<List<Gist>> {
            override fun onFailure(call: Call<List<Gist>>, t: Throwable) {
                onFailureListener.onFailure(t)
            }

            override fun onResponse(call: Call<List<Gist>>, response: Response<List<Gist>>) {
                onSuccessListener
                    .let { it as GistOnSuccessListener }
                    .onSuccess(response.body())
            }
        })
    }

    fun getStarredGists(
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        githubService.getStarredGists().enqueue(object : Callback<List<Gist>> {
            override fun onFailure(call: Call<List<Gist>>, t: Throwable) {
                onFailureListener.onFailure(t)
            }

            override fun onResponse(call: Call<List<Gist>>, response: Response<List<Gist>>) {
                onSuccessListener
                    .let { it as GistOnSuccessListener }
                    .onSuccess(response.body())
            }
        })
    }

    fun getUserGists(
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        githubService.getUserGists().enqueue(object : Callback<List<Gist>> {
            override fun onFailure(call: Call<List<Gist>>, t: Throwable) {
                onFailureListener.onFailure(t)
            }

            override fun onResponse(call: Call<List<Gist>>, response: Response<List<Gist>>) {
                onSuccessListener
                    .let { it as GistOnSuccessListener }
                    .onSuccess(response.body())
            }
        })
    }

    fun getGist(
        gistId: String,
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        githubService.getGist(gistId).enqueue(object : Callback<Gist> {
            override fun onFailure(call: Call<Gist>, t: Throwable) {
                onFailureListener.onFailure(t)
            }

            override fun onResponse(call: Call<Gist>, response: Response<Gist>) {
                onSuccessListener
                    .let { it as GistOnSuccessListener }
                    .onSuccess(response.body())
            }
        })
    }

    fun getGistCommentsById(
        gistId: String,
        pageNumber: Int,
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        githubService.getGistCommentsById(gistId, pageNumber)
            .enqueue(object : Callback<List<GistComment>> {
                override fun onFailure(call: Call<List<GistComment>>, t: Throwable) {
                    onFailureListener.onFailure(t)
                }

                override fun onResponse(
                    call: Call<List<GistComment>>,
                    response: Response<List<GistComment>>
                ) {
                    onSuccessListener
                        .let { it as GistCommentOnSuccessListener }
                        .onSuccess(response.body())

                }
            })
    }

    fun getGistCommentHeadersById(
        gistId: String,
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        githubService.getGistCommentHeadersById(gistId).enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                onFailureListener.onFailure(t)
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                onSuccessListener.let { it as GistCommentOnSuccessListener }
                    .onSuccess(response.headers())
            }

        })
    }

    fun getLoggedInUser(
        auth: String,
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        githubService.getLoggedInUser(auth).enqueue(object : Callback<GitHubUser> {
            override fun onFailure(call: Call<GitHubUser>, t: Throwable) {
                onFailureListener.onFailure(t)
            }

            override fun onResponse(call: Call<GitHubUser>, response: Response<GitHubUser>) {
                onSuccessListener
                    .let { it as GitHubUserOnSuccessListener }
                    .onSuccess(response.body())
            }
        })
    }
}