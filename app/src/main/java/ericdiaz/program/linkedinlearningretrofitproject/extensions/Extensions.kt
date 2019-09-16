package ericdiaz.program.linkedinlearningretrofitproject.extensions

import android.content.Context
import android.widget.Toast
import java.text.DateFormat
import java.util.*

fun Date.format(): String {
    return DateFormat.getDateInstance().format(this)
}


fun String.makeToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}