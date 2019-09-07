package ericdiaz.program.linkedinlearningretrofitproject.repository

import ericdiaz.program.linkedinlearningretrofitproject.api.GithubService
import ericdiaz.program.linkedinlearningretrofitproject.callback.OnFailureListener
import ericdiaz.program.linkedinlearningretrofitproject.callback.OnSuccessListener
import ericdiaz.program.linkedinlearningretrofitproject.model.Gist
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
                onSuccessListener.onSuccess(response.body())
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
                onSuccessListener.onSuccess(response.body())
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
                onSuccessListener.onSuccess(response.body())
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
                onSuccessListener.onSuccess(response.body())
            }
        })
    }
}