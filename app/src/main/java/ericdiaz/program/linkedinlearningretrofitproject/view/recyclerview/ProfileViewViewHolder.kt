package ericdiaz.program.linkedinlearningretrofitproject.view.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ericdiaz.program.linkedinlearningretrofitproject.R
import ericdiaz.program.linkedinlearningretrofitproject.model.Gist

class ProfileViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val userProfilePicImageView: ImageView =
        itemView.findViewById(R.id.user_profile_pic_image_view)
    private val gistNameTextView: TextView =
        itemView.findViewById(R.id.gist_name_text_view)
    private val gistDescriptionTextView: TextView =
        itemView.findViewById(R.id.gist_description_text_view)
    private val dateCreatedTextView: TextView =
        itemView.findViewById(R.id.date_created_text_view)


    fun onBind(gist: Gist) {
        Picasso.get().load(gist.gitHubUser.photoUrl).into(userProfilePicImageView)
        gistNameTextView.text = gist.gitHubUser.userName
        gistDescriptionTextView.text = gist.description
        dateCreatedTextView.text = gist.createdAt.toString()
    }
}

