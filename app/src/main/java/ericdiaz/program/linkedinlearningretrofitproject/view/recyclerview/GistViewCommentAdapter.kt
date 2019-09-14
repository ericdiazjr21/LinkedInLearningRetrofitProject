package ericdiaz.program.linkedinlearningretrofitproject.view.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ericdiaz.program.linkedinlearningretrofitproject.R
import ericdiaz.program.linkedinlearningretrofitproject.model.GistComment

class GistViewCommentAdapter : RecyclerView.Adapter<GistViewCommentViewHolder>() {

    private val gistComments: MutableList<GistComment> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistViewCommentViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.gist_comment_item_view, parent, false)
        return GistViewCommentViewHolder(view)

    }

    override fun getItemCount(): Int {
        return gistComments.size
    }

    override fun onBindViewHolder(holder: GistViewCommentViewHolder, position: Int) {
        holder.onBind(gistComments[position])
    }

    fun addData(comments: List<GistComment>) {
        gistComments.addAll(comments)
    }

    fun addData(comment: GistComment) {
        gistComments.add(gistComments.size - 1, comment)
    }

}