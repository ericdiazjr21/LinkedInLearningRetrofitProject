package ericdiaz.program.linkedinlearningretrofitproject.model

import com.google.gson.annotations.SerializedName

data class Gist(
    @SerializedName("id") val gistId: String,
    @SerializedName("files") val gistFiles: Map<String, GistFile>,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("description") val description: String,
    @SerializedName("owner") val gitHubUser : GitHubUser
)