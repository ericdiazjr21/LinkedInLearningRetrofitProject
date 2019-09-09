package ericdiaz.program.linkedinlearningretrofitproject.viewmodel

import ericdiaz.program.linkedinlearningretrofitproject.callback.OnFailureListener
import ericdiaz.program.linkedinlearningretrofitproject.callback.OnSuccessListener
import ericdiaz.program.linkedinlearningretrofitproject.repository.GitHubServiceRepository

class GitHubViewModel(private val gitHubServiceRepository: GitHubServiceRepository) {

    lateinit var currentGistId: String

    fun getPublicGists(
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        gitHubServiceRepository.getPublicGists(onSuccessListener, onFailureListener)
    }

    fun getGist(
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        gitHubServiceRepository.getGist(currentGistId, onSuccessListener, onFailureListener)
    }

    fun getStarredGists(
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        gitHubServiceRepository.getStarredGists(onSuccessListener, onFailureListener)
    }

    fun getUserGists(
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        gitHubServiceRepository.getUserGists(onSuccessListener, onFailureListener)
    }

}