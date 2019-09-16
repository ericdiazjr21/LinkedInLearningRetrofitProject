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

    fun getGistCommentsById(
        gistId: String,
        pageNumber: Int,
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        gitHubServiceRepository.getGistCommentsById(
            gistId,
            pageNumber,
            onSuccessListener,
            onFailureListener
        )
    }

    fun getGistCommentHeadersById(
        gistId: String,
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        gitHubServiceRepository.getGistCommentHeadersById(
            gistId,
            onSuccessListener,
            onFailureListener
        )
    }

    fun getLoggedInUser(
        userName: String,
        accessToken: String,
        onSuccessListener: OnSuccessListener,
        onFailureListener: OnFailureListener
    ) {
        gitHubServiceRepository.getLoggedInUser(userName,accessToken,onSuccessListener, onFailureListener)
    }

}