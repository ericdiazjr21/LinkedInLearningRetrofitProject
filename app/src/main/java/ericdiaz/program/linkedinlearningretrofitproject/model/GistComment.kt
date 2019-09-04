package ericdiaz.program.linkedinlearningretrofitproject.model

import com.google.gson.annotations.SerializedName

data class GistComment(
    @SerializedName("id") val commentId: Int,
    @SerializedName("body") val body: String,
    @SerializedName("user") val gitHubUser: GitHubUser,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String
)