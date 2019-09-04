package ericdiaz.program.linkedinlearningretrofitproject.model

import com.google.gson.annotations.SerializedName

data class GitHubUser(
    @SerializedName("login") val userName: String,
    @SerializedName("id") val userId: Int,
    @SerializedName("avatar_url") val photoUrl: String,
    @SerializedName("name") val fullName: String,
    @SerializedName("company") val userCompany: String,
    @SerializedName("blog") val userBlogSite: String,
    @SerializedName("location") val userLocation: String,
    @SerializedName("email") val userEmail: String,
    @SerializedName("bio") val userBio: String,
    @SerializedName("public_gist") val userPublicGistCount: Int,
    @SerializedName("followers") val userFollowers: Int,
    @SerializedName("following") val userFollowing: Int,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("private_gist") val userPrivateGistCount: Int
)
