package com.example.alefdevelopementtesttask.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.alefdevelopementtesttask.domain.ImageItem

object ImageListDiffCallback : DiffUtil.ItemCallback<ImageItem>() {

    override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
        return oldItem.imageUrl == newItem.imageUrl
    }

    override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
        return oldItem == newItem
    }
}
