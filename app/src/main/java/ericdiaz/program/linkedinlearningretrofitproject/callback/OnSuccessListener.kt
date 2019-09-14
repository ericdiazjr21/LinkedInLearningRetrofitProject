package ericdiaz.program.linkedinlearningretrofitproject.callback

import ericdiaz.program.linkedinlearningretrofitproject.model.Gist
import ericdiaz.program.linkedinlearningretrofitproject.model.GistComment
import okhttp3.Headers

interface OnSuccessListener

interface GistOnSuccessListener : OnSuccessListener {
    fun onSuccess(gists: List<Gist>?) {}
    fun onSuccess(gist: Gist?) {}
}

interface GistCommentOnSuccessListener : OnSuccessListener {
    fun onSuccess(gistComments: List<GistComment>?) {}
    fun onSuccess(headers: Headers) {}
}