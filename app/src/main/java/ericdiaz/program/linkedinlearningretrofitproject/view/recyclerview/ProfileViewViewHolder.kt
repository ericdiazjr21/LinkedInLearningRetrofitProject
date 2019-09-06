package ericdiaz.program.linkedinlearningretrofitproject.view.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ericdiaz.program.linkedinlearningretrofitproject.model.Gist

class ProfileViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var userProfilePicImageView: ImageView
    private lateinit var gistNameTextView: TextView
    private lateinit var gistDescriptionTextView: TextView
    private lateinit var dateCreatedTextView: TextView


    fun onBind(gist: Gist) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

