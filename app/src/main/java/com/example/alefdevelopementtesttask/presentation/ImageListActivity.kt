package com.example.alefdevelopementtesttask.presentation

import android.graphics.Point
import android.hardware.display.DisplayManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.alefdevelopementtesttask.R
import com.example.alefdevelopementtesttask.databinding.ActivityImageListBinding
import com.example.alefdevelopementtesttask.domain.ImageItem
import com.example.alefdevelopementtesttask.presentation.adapters.ImageListAdapter
import android.view.WindowManager
import android.util.DisplayMetrics
import android.view.WindowMetrics
import androidx.core.content.getSystemService
import java.security.AccessController.getContext


class ImageListActivity : AppCompatActivity() {

    private lateinit var viewModel: ImageListViewModel

    private val binding by lazy {
        ActivityImageListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.swipeRefreshLayout?.setOnRefreshListener {
            viewModel.loadData()
        }
        setAdapter()
    }

    private fun setAdapter() {
        val adapter = ImageListAdapter(this)
        adapter.onCoinClickListener = object : ImageListAdapter.OnCoinClickListener {
            override fun onImageItemClick(imageItem: ImageItem) {
                if (isOnePaneMode()) {
                    launchDetailActivity(imageItem.imageUrl)
                } else {
                    launchDetailFragment(imageItem.imageUrl)
                }
            }
        }
        countOfColumn()
        binding.rvImageList.layoutManager = GridLayoutManager(this, countOfColumn())
        binding.rvImageList.adapter = adapter
        viewModel = ViewModelProvider(this)[ImageListViewModel::class.java]
        viewModel.imageItemList.observe(this) {
            adapter.submitList(it)
            binding.swipeRefreshLayout?.isRefreshing = false
        }
    }

    private fun launchDetailActivity(url: String) {
        val intent = ImageDetailActivity.newIntent(
            this@ImageListActivity,
            url
        )
        startActivity(intent)
    }

    private fun launchDetailFragment(url: String) {
        supportFragmentManager.popBackStack()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, ImageDetailFragment.newInstance(url))
            .addToBackStack(null)
            .commit()
    }

    private fun isOnePaneMode() = binding.fragmentContainer == null

    private fun countOfColumn(): Int {
        return if (displayMetrics() < 600) {
            2
        } else {
            3
        }
    }

    private fun displayMetrics(): Int {
        val width = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            this.windowManager.currentWindowMetrics.bounds.width()
        } else {
            val display = windowManager.defaultDisplay
            val size = Point()
            display.getSize(size)
            size.x
        }
        return pxToDp(width)
    }

    private fun pxToDp(px: Int): Int {
        val displayMetrics: DisplayMetrics = this.resources.displayMetrics
        val width = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
        return width
    }
}