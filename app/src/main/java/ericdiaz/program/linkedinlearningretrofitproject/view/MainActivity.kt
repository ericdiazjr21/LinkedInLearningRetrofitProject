package ericdiaz.program.linkedinlearningretrofitproject.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ericdiaz.program.linkedinlearningretrofitproject.R
import ericdiaz.program.linkedinlearningretrofitproject.api.RetrofitSingleton
import ericdiaz.program.linkedinlearningretrofitproject.repository.GitHubServiceRepository
import ericdiaz.program.linkedinlearningretrofitproject.viewmodel.GitHubViewModel

class MainActivity : AppCompatActivity() {

    private val gitHubServiceRepository = GitHubServiceRepository(RetrofitSingleton.gitHubService)
    private val gitHubViewModel = GitHubViewModel(gitHubServiceRepository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
    }
}