package ericdiaz.program.linkedinlearningretrofitproject.repository

import ericdiaz.program.linkedinlearningretrofitproject.api.GithubService
import ericdiaz.program.linkedinlearningretrofitproject.model.Gist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitHubServiceRepository constructor(
    private val githubService: GithubService,
    private val repositoryCallback: RepositoryCallback
) {


    fun getPublicGists() {
        githubService.getPublicGists().enqueue(object : Callback<List<Gist>> {
            override fun onFailure(call: Call<List<Gist>>, t: Throwable) {
                repositoryCallback.onFailure(t)
            }

            override fun onResponse(call: Call<List<Gist>>, response: Response<List<Gist>>) {
                repositoryCallback.onSuccess(response.body())
            }
        })
    }

    fun getStarredGists() {
        githubService.getStarredGists().enqueue(object : Callback<List<Gist>> {
            override fun onFailure(call: Call<List<Gist>>, t: Throwable) {
                repositoryCallback.onFailure(t)
            }

            override fun onResponse(call: Call<List<Gist>>, response: Response<List<Gist>>) {
                repositoryCallback.onSuccess(response.body())
            }
        })
    }

    fun getUserGists() {
        githubService.getUserGists().enqueue(object : Callback<List<Gist>> {
            override fun onFailure(call: Call<List<Gist>>, t: Throwable) {
                repositoryCallback.onFailure(t)
            }

            override fun onResponse(call: Call<List<Gist>>, response: Response<List<Gist>>) {
                repositoryCallback.onSuccess(response.body())
            }
        })
    }
}