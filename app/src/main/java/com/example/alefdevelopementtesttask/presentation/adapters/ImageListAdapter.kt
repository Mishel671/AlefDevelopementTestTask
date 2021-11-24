package com.example.alefdevelopementtesttask.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.alefdevelopementtesttask.databinding.ItemImageBinding
import com.example.alefdevelopementtesttask.domain.ImageItem
import com.squareup.picasso.Picasso

class ImageListAdapter(
    private val context: Context
) : ListAdapter<ImageItem, ImageListViewHolder>(ImageListDiffCallback) {

    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        val binding = ItemImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            with(item) {
                Picasso.get().load(imageUrl).into(imageViewItem)
                root.setOnClickListener {
                    onCoinClickListener?.onImageItemClick(this)
                }
            }
        }
    }

    interface OnCoinClickListener {
        fun onImageItemClick(imageItem: ImageItem)
    }
}