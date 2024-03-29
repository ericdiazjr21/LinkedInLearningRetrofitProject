package ericdiaz.program.linkedinlearningretrofitproject.view

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import ericdiaz.program.linkedinlearningretrofitproject.R
import ericdiaz.program.linkedinlearningretrofitproject.view.recyclerview.ProfileViewViewHolder
import ericdiaz.program.linkedinlearningretrofitproject.viewmodel.GitHubViewModel
import ericdiaz.program.linkedinlearningretrofitproject.viewmodel.GitHubViewModelProvider

class MainActivity :
    AppCompatActivity(),
    ProfileViewViewHolder.OnItemViewClickedListener {
    private lateinit var mainContainer: ViewGroup

    private lateinit var bottomNavBar: BottomNavigationView
    private lateinit var profileView: View
    private lateinit var searchGistsView: View
    private lateinit var starredGistsView: View
    private lateinit var userGistsView: View
    private lateinit var gistView: View

    private lateinit var gitHubViewModel: GitHubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gitHubViewModel = GitHubViewModelProvider.gitHubViewModel

        mainContainer = findViewById(R.id.main_container)
        bottomNavBar = findViewById(R.id.bottom_navigation)

        profileView = layoutInflater.inflate(R.layout.view_profile, null)
        searchGistsView = layoutInflater.inflate(R.layout.view_search_gists, null)
        starredGistsView = layoutInflater.inflate(R.layout.view_starred_gists, null)
        userGistsView = layoutInflater.inflate(R.layout.view_user_gists, null)
        gistView = layoutInflater.inflate(R.layout.view_gist, null)

        mainContainer.addView(profileView)

        bottomNavBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.profile_view -> {
                    mainContainer.removeAllViews()
                    mainContainer.addView(profileView)
                }
                R.id.search_view -> {
                    mainContainer.removeAllViews()
                    mainContainer.addView(searchGistsView)
                }
                R.id.starred_view -> {
                    mainContainer.removeAllViews()
                    mainContainer.addView(starredGistsView)
                }
                R.id.user_view -> {
                    mainContainer.removeAllViews()
                    mainContainer.addView(userGistsView)
                }
                else -> Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun itemViewClicked(gistId: String) {
        gitHubViewModel. currentGistId = gistId
        mainContainer.removeAllViews()
        mainContainer.addView(gistView)
    }
}
