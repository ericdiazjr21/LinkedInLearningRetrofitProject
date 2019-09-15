package ericdiaz.program.linkedinlearningretrofitproject.view

import android.content.Context
import android.util.AttributeSet
import android.util.Base64
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import ericdiaz.program.linkedinlearningretrofitproject.R
import ericdiaz.program.linkedinlearningretrofitproject.callback.GitHubUserOnSuccessListener
import ericdiaz.program.linkedinlearningretrofitproject.callback.OnFailureListener
import ericdiaz.program.linkedinlearningretrofitproject.model.GitHubUser
import ericdiaz.program.linkedinlearningretrofitproject.viewmodel.GitHubViewModelProvider

class UserGistsView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private lateinit var userNameEditText: EditText
    private lateinit var passWordEditText: EditText
    private lateinit var loginButton: Button

    private val gitHubViewModel = GitHubViewModelProvider.gitHubViewModel

    override fun onFinishInflate() {
        super.onFinishInflate()

        userNameEditText = findViewById(R.id.user_name_edit_text)
        passWordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener {
            val userName = userNameEditText.text.toString()
            val passWord = passWordEditText.text.toString()
            val authString =
                Base64.encodeToString(("$userName:$passWord").toByteArray(), Base64.NO_WRAP)

            gitHubViewModel.getLoggedInUser(
                authString,
                object : GitHubUserOnSuccessListener {
                    override fun onSuccess(gitHubUser: GitHubUser?) {
                        if (gitHubUser != null) {
                            makeToast(gitHubUser.fullName)
                        }
                    }
                },
                object : OnFailureListener {
                    override fun onFailure(throwable: Throwable) {
                        makeToast(throwable.localizedMessage)
                    }
                })

        }
    }

    fun makeToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }


}