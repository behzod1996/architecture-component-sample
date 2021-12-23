package com.behzoddev.architecturecomponentsample.common

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Context.toastLong(message: String) {
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}
fun Context.toastShort(message: String) {
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}
fun Fragment.toastLong(message: String) {
    Toast.makeText(activity,message, Toast.LENGTH_LONG).show()
}
fun Fragment.toastShort(message: String){
    Toast.makeText(activity,message, Toast.LENGTH_SHORT).show()
}