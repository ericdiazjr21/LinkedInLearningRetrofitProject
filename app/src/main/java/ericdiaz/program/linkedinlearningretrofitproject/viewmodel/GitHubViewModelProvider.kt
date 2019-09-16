package ericdiaz.program.linkedinlearningretrofitproject.viewmodel

import ericdiaz.program.linkedinlearningretrofitproject.api.RetrofitSingleton
import ericdiaz.program.linkedinlearningretrofitproject.repository.GitHubServiceRepository

object GitHubViewModelProvider {

    private val gitHubServiceRepository = GitHubServiceRepository(RetrofitSingleton.githubService)

    val gitHubViewModel = GitHubViewModel(gitHubServiceRepository)
}