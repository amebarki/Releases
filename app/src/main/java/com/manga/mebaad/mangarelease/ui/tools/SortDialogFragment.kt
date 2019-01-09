package com.manga.mebaad.mangarelease.ui.tools

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.manga.mebaad.mangarelease.R
import com.manga.mebaad.mangarelease.base.activity.showToast

class SortDialogFragment : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setView(activity?.layoutInflater?.inflate(R.layout.dialog_sort,null))
                    .setPositiveButton("Positive"
                    ) { dialog, id ->
                        activity?.showToast("Positive")
                    }
                    .setNegativeButton("Cancel"
                    ) { dialog, id ->
                        activity?.showToast("Cancel")
                        // User cancelled the dialog
                    }
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }

}