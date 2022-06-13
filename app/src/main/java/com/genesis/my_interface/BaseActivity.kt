package com.genesis.my_interface

interface BaseActivity {
    fun showLoading(isShowLoading: Boolean)
    fun showLoading(
        title: String? = null,
        message: String
    )
}