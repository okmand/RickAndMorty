package com.okmyan.rickandmorty.ui_kit.extensions

import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.okmyan.rickandmorty.ui_kit.R

fun Fragment.showAlertDialog(
    title: String,
    message: String = "",
    positiveButton: String = "",
    positiveButtonCallback: () -> Unit = {},
) {
    val builder: AlertDialog.Builder? = activity?.let {
        AlertDialog.Builder(it)
    }
    val dialog = builder?.apply {
        setTitle(title)
        if (message.isNotBlank()) {
            setMessage(message)
        }
        if (positiveButton.isNotBlank()) {
            setPositiveButton(R.string.retry) { _, _ ->
                positiveButtonCallback()
            }
        }
    }?.create()

    context?.apply {
        dialog?.window?.setBackgroundDrawable(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.dialog_background,
                theme
            )
        )
    }

    dialog?.show()
}
