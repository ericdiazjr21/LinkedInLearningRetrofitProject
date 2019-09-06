package ericdiaz.program.linkedinlearningretrofitproject.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ericdiaz.program.linkedinlearningretrofitproject.R
import ericdiaz.program.linkedinlearningretrofitproject.api.RetrofitSingleton
import ericdiaz.program.linkedinlearningretrofitproject.callback.OnFailureListener
import ericdiaz.program.linkedinlearningretrofitproject.callback.OnSuccessListener
import ericdiaz.program.linkedinlearningretrofitproject.model.Gist
import ericdiaz.program.linkedinlearningretrofitproject.repository.GitHubServiceRepository
import ericdiaz.program.linkedinlearningretrofitproject.view.recyclerview.ProfileViewAdapter
import ericdiaz.program.linkedinlearningretrofitproject.viewmodel.GitHubViewModel

class ProfileView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    private lateinit var profileViewRecyclerView: RecyclerView


    override fun onFinishInflate() {
        super.onFinishInflate()

        profileViewRecyclerView = findViewById(R.id.profile_view_recycler_view)
        profileViewRecyclerView.layoutManager = LinearLayoutManager(context)
        val profileViewAdapter = ProfileViewAdapter()
        profileViewRecyclerView.adapter = profileViewAdapter

        val gitHubServiceRepository = GitHubServiceRepository(RetrofitSingleton.gitHubService)
        val gitHubViewModel = GitHubViewModel(gitHubServiceRepository)

        gitHubViewModel.getPublicGists(object : OnSuccessListener {
            override fun onSuccess(gists: List<Gist>?) {
                if (gists != null) {
                    profileViewAdapter.setData(gists)
                }
            }

        }, object : OnFailureListener {
            override fun onFailure(throwable: Throwable) {
                Toast.makeText(context, throwable.toString(), Toast.LENGTH_LONG).show()
            }
        })


    }
}