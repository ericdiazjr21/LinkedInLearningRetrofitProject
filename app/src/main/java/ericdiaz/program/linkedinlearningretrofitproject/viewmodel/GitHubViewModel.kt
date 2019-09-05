package ericdiaz.program.linkedinlearningretrofitproject.viewmodel

import ericdiaz.program.linkedinlearningretrofitproject.repository.GitHubServiceRepository

class GitHubViewModel(val gitHubServiceRepository: GitHubServiceRepository) {

    fun getPublicGists() {
        gitHubServiceRepository.getPublicGists()
    }

    fun getStarredGists() {
        gitHubServiceRepository.getStarredGists()
    }

    fun getUserGists() {
        gitHubServiceRepository.getUserGists()
    }

}