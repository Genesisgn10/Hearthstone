package com.genesis.extensions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.genesis.meals.R
import com.genesis.my_interface.BaseActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

fun FragmentActivity?.checkActivityAndShowBottomSheet(
    bottomSheet: BottomSheetDialogFragment,
    tag: String?
) {
    this?.let {
        bottomSheet.show(it.supportFragmentManager, tag)
    }
}

fun FragmentActivity.changeContent(fragment: Fragment, content: Int, addBackStack: Boolean) {
    val transaction = supportFragmentManager.beginTransaction().replace(content, fragment)
    if (addBackStack) transaction.addToBackStack(fragment.tag)
    transaction.commit()
    supportFragmentManager.executePendingTransactions()
}

fun FragmentActivity?.hideKeyboard() {
    if (this != null) {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}

fun FragmentActivity?.showKeyboard() {
    if (this != null) {
        val view = this.currentFocus
        if (view != null) {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(this.currentFocus, InputMethodManager.HIDE_IMPLICIT_ONLY); }
    }
}

fun FragmentActivity.findNavController(@IdRes id: Int): NavController? {
    return supportFragmentManager
        .findFragmentById(id)?.findNavController()
}

fun FragmentActivity.getNavHostFragment(@IdRes id: Int): NavHostFragment {
    return supportFragmentManager
        .findFragmentById(id) as NavHostFragment
}

fun FragmentActivity.setFullscreen(isFullscreen: Boolean) {
    if (isFullscreen)
        window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    else
        window?.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}


fun FragmentActivity.showLoading(isToShowLoading: Boolean) {
    if (this is BaseActivity) {
        this.showLoading(isToShowLoading)
    }
}

fun FragmentActivity.showError(
    title: String? = null,
    message: String,
    buttonText: String = getString(R.string.app_name)
) {
    if (this is BaseActivity) {
        this.showError(title, message, buttonText)
    }
}

fun <T> FragmentActivity.goToActivity(target: Class<T>, bundle: Bundle? = null) {
    val intent = Intent(this, target)
    if (bundle != null) intent.putExtras(bundle)
    startActivity(intent)
}