package ericdiaz.program.linkedinlearningretrofitproject.extensions

import java.text.DateFormat
import java.util.*

fun Date.format(): String {
    return DateFormat.getDateInstance().format(this)
}