package com.example.alefdevelopementtesttask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.alefdevelopementtesttask.R
import com.example.alefdevelopementtesttask.databinding.ActivityImageListBinding
import com.example.alefdevelopementtesttask.domain.ImageItem
import com.example.alefdevelopementtesttask.presentation.adapters.ImageListAdapter

class ImageListActivity : AppCompatActivity() {

    private lateinit var viewModel: ImageListViewModel

    private val binding by lazy {
        ActivityImageListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = ImageListAdapter(this)
        adapter.onCoinClickListener = object : ImageListAdapter.OnCoinClickListener {
            override fun onImageItemClick(imageItem: ImageItem) {
                if (isOnePaneMode()) {
                    launchDetailActivity(imageItem.id)
                } else {
                    launchDetailFragment(imageItem.id)
                }
            }
        }
        binding.imageList?.adapter = adapter
        binding.imageList?.itemAnimator = null
        viewModel = ViewModelProvider(this)[ImageListViewModel::class.java]
        viewModel.imageItemList.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun launchDetailActivity(id: Int) {
//        val intent = CoinDetailActivity.newIntent(
//            this@CoinPriceListActivity,
//            fromSymbol
//        )
//        startActivity(intent)
    }

    private fun launchDetailFragment(id: Int) {
//        supportFragmentManager.popBackStack()
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.fragment_container, CoinDetailFragment.newInstance(fromSymbol))
//            .addToBackStack(null)
//            .commit()
    }

    private fun isOnePaneMode() = binding.fragmentContainer == null
}