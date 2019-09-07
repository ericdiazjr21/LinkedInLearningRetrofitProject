package ericdiaz.program.linkedinlearningretrofitproject.callback

import ericdiaz.program.linkedinlearningretrofitproject.model.Gist

interface OnSuccessListener {
    fun onSuccess(gists: List<Gist>?){}
    fun onSuccess(gist: Gist?){}
}