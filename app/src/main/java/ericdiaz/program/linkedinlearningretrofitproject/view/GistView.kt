package ericdiaz.program.linkedinlearningretrofitproject.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.picasso.Picasso
import ericdiaz.program.linkedinlearningretrofitproject.R
import ericdiaz.program.linkedinlearningretrofitproject.callback.GistOnSuccessListener
import ericdiaz.program.linkedinlearningretrofitproject.callback.OnFailureListener
import ericdiaz.program.linkedinlearningretrofitproject.callback.OnSuccessListener
import ericdiaz.program.linkedinlearningretrofitproject.extensions.format
import ericdiaz.program.linkedinlearningretrofitproject.model.Gist
import ericdiaz.program.linkedinlearningretrofitproject.viewmodel.GitHubViewModelProvider

class GistView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private val gitHubViewModel = GitHubViewModelProvider.gitHubViewModel

    private lateinit var githubUserPicImageView: ImageView
    private lateinit var gistIdTextView: TextView
    private lateinit var gistDateCreatedTextView: TextView
    private lateinit var gistNumberOfFilesTextView: TextView
    private lateinit var gistLastUpdatedTextView: TextView
    private lateinit var gistDescriptionTextView: TextView

    override fun onFinishInflate() {
        super.onFinishInflate()
        githubUserPicImageView = findViewById(R.id.git_hub_user_pic)
        gistIdTextView = findViewById(R.id.git_hub_user_name)
        gistDateCreatedTextView = findViewById(R.id.date_created_text_view)
        gistNumberOfFilesTextView = findViewById(R.id.number_of_files_text_view)
        gistLastUpdatedTextView = findViewById(R.id.date_updated_text_view)
        gistDescriptionTextView = findViewById(R.id.description_text_view)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        gitHubViewModel.getGist(
            object : GistOnSuccessListener {
                override fun onSuccess(gist: Gist?) {
                    Picasso.get().load(gist?.gitHubUser?.photoUrl).into(githubUserPicImageView)
                    gistIdTextView.text = gist?.gistId
                    gistDateCreatedTextView.text = gist?.createdAt?.format()
                    gistNumberOfFilesTextView.text = gist?.gistFiles?.size.toString()
                    gistLastUpdatedTextView.text = gist?.updatedAt?.format()
                    gistDescriptionTextView.text = gist?.description
                }
            },
            object : OnFailureListener {
                override fun onFailure(throwable: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })

        gitHubViewModel.
    }


}