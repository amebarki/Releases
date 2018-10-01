package com.manga.mebaad.mangarelease.base.view

import android.util.Log

/**
 * Activity and Fragment must implement there own View.
 * The View is injected in the presenter.
 * You have to extends this interface and add methods to update view.
 */
interface BaseView {

    /**
     * Display a error with a String message
     */
    fun showError(errorMessage: String) {
        Log.e("BaseView", "showError: $errorMessage")
    }


}