package ericdiaz.program.linkedinlearningretrofitproject.view.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ericdiaz.program.linkedinlearningretrofitproject.model.GistComment
import kotlinx.android.synthetic.main.gist_comment_item_view.view.*

class GistViewCommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(gistComment: GistComment) {
        Picasso.get().load(gistComment.gitHubUser.photoUrl)
            .into(itemView.gist_view_user_pic_image_view)
        itemView.gist_view_date_created_text_view.text = gistComment.createdAt
        itemView.gist_comment_body.text = gistComment.body
    }
}