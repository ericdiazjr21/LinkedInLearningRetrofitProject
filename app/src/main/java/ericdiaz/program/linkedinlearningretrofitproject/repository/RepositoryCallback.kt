package ericdiaz.program.linkedinlearningretrofitproject.repository

import ericdiaz.program.linkedinlearningretrofitproject.model.Gist

interface RepositoryCallback {

    fun onSuccess(gists: List<Gist>?)

    fun onFailure(throwable: Throwable)
}