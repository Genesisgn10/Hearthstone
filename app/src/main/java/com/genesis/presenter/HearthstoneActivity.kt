package com.genesis.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.genesis.extensions.setVisible
import com.genesis.meals.databinding.ActivityMainBinding
import com.genesis.my_interface.BaseActivity

class HearthstoneActivity : AppCompatActivity(), BaseActivity {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun showLoading(isShowLoading: Boolean) {
        binding?.run {
            progress.setVisible(isShowLoading)
            viewProgress.setVisible(isShowLoading)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun showLoading(title: String?, message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}