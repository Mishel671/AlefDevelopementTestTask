package com.example.alefdevelopementtesttask.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.alefdevelopementtesttask.databinding.FragmentImageDetailBinding
import com.squareup.picasso.Picasso

class ImageDetailFragment : Fragment() {

    private lateinit var viewModel: DetailFragmentViewModel

    private var _binding: FragmentImageDetailBinding? = null
    private val binding: FragmentImageDetailBinding
    get() = _binding?: throw RuntimeException("FragmentImageDetailBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageUrl = getImageUrl()
        viewModel = ViewModelProvider(this)[DetailFragmentViewModel::class.java]
        viewModel.getDetailImage(imageUrl).observe(viewLifecycleOwner){
            Picasso.get().load(it.imageUrl).into(binding.imageViewDetail)
        }

    }

    private fun getImageUrl(): String {
        return requireArguments().getString(EXTRA_FROM_URL, EMPTY_URL)
    }

    companion object {
        private const val EXTRA_FROM_URL = "url"
        private const val EMPTY_URL = ""

        fun newInstance(url: String): Fragment {
            return ImageDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_FROM_URL, url)
                }
            }
        }
    }
}