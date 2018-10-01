package com.manga.mebaad.mangarelease.base.activity

import android.app.Activity
import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.showSnackBar(parent: View, title: String? = null, message: String, color: Int? = null, actionName: String? = null, action: ((v: View) -> Unit)? = null) {
    val snackbar = Snackbar.make(
            parent,
            if (title != null) {
                "$title: $message"
            } else {
                message
            },
            Snackbar.LENGTH_LONG
    )
    if (actionName != null && action != null) {
        snackbar.setAction(actionName, action)
    }
    if (color != null) {
        snackbar.view.background = ContextCompat.getDrawable(this, color)
    }
    snackbar.show()
}

fun Activity.hideKeyBoard() =
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .hideSoftInputFromWindow(
                        this.currentFocus?.windowToken,
                        0
                )



