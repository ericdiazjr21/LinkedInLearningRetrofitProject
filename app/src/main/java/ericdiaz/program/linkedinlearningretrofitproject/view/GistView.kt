package ericdiaz.program.linkedinlearningretrofitproject.view

import android.content.Context
import android.util.AttributeSet
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import ericdiaz.program.linkedinlearningretrofitproject.callback.OnFailureListener
import ericdiaz.program.linkedinlearningretrofitproject.callback.OnSuccessListener
import ericdiaz.program.linkedinlearningretrofitproject.model.Gist

class GistView(context: Context, attrs: AttributeSet?) :
    ConstraintLayout(context, attrs),
    OnSuccessListener,
    OnFailureListener {

    override fun onFinishInflate() {
        super.onFinishInflate()

    }

    override fun onSuccess(gist: Gist?) {
        Toast.makeText(context, gist?.gistId.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onFailure(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}