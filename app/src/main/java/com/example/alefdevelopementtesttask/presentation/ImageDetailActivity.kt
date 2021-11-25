package com.example.alefdevelopementtesttask.presentation

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.ActionBar
import com.example.alefdevelopementtesttask.R
import com.example.alefdevelopementtesttask.databinding.ActivityImageDetailBinding

class ImageDetailActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityImageDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        if (!intent.hasExtra(EXTRA_URL)) {
            finish()
            return
        }
        val url = intent.getStringExtra(EXTRA_URL)?: EMPTY_SYMBOL
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, ImageDetailFragment.newInstance(url))
                .commit()
        }
    }

    companion object {
        private const val EXTRA_URL= "url"
        private const val EMPTY_SYMBOL = ""

        fun newIntent(context: Context, url: String): Intent {
            val intent = Intent(context, ImageDetailActivity::class.java)
            intent.putExtra(EXTRA_URL, url)
            return intent
        }
    }
}