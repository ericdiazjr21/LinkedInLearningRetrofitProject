package ericdiaz.program.linkedinlearningretrofitproject.viewmodel

import ericdiaz.program.linkedinlearningretrofitproject.api.RetrofitSingleton
import ericdiaz.program.linkedinlearningretrofitproject.repository.GitHubServiceRepository

object GitHubViewModelProvider {

    private val gitHubServiceRepository =
        GitHubServiceRepository(RetrofitSingleton.gitHubService)

    val gitHubViewModel = GitHubViewModel(gitHubServiceRepository)
}