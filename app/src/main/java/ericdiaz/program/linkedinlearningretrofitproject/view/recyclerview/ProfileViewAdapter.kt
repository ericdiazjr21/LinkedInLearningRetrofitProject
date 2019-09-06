package ericdiaz.program.linkedinlearningretrofitproject.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ericdiaz.program.linkedinlearningretrofitproject.R
import ericdiaz.program.linkedinlearningretrofitproject.model.Gist

class ProfileViewAdapter : RecyclerView.Adapter<ProfileViewViewHolder>() {

    private val publicGists: MutableList<Gist> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_view_item_view, parent, false)
        return ProfileViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return publicGists.size
    }

    override fun onBindViewHolder(holder: ProfileViewViewHolder, position: Int) {
        holder.onBind(publicGists[position])
    }

    fun setData(newGistLists: ArrayList<Gist>) {
        publicGists.clear()
        publicGists.addAll(newGistLists)
        notifyDataSetChanged()
    }
}