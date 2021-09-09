package com.ayanoguz.marvel.util.extensions

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.ayanoguz.marvel.ui.progressDialog.ProgressDialogFragment


fun Fragment.showProgressDialog() {
    val dialogProgressFragment = ProgressDialogFragment()
    val prev: DialogFragment? =
        requireActivity().supportFragmentManager.findFragmentByTag("dialogProgress") as DialogFragment?
    if (prev == null)
        dialogProgressFragment.show(requireActivity().supportFragmentManager, "dialogProgress")


}

fun Fragment.dismissProgressDialog() {
    val prev: DialogFragment? =
        requireActivity().supportFragmentManager.findFragmentByTag("dialogProgress") as DialogFragment?
    prev?.dismiss()
}

