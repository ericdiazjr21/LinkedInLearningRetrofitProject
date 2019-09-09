package ericdiaz.program.linkedinlearningretrofitproject.view

import android.content.Context
import android.util.AttributeSet
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import ericdiaz.program.linkedinlearningretrofitproject.callback.OnFailureListener
import ericdiaz.program.linkedinlearningretrofitproject.callback.OnSuccessListener
import ericdiaz.program.linkedinlearningretrofitproject.model.Gist
import ericdiaz.program.linkedinlearningretrofitproject.viewmodel.GitHubViewModelProvider

class GistView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private val gitHubViewModel = GitHubViewModelProvider.gitHubViewModel

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        gitHubViewModel.getGist(
            object : OnSuccessListener {
                override fun onSuccess(gist: Gist?) {
                    Toast.makeText(context, gist?.gistId, Toast.LENGTH_LONG).show()
                }
            },
            object : OnFailureListener {
                override fun onFailure(throwable: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
    }


}