package com.okmyan.rickandmorty.charactersscreen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.okmyan.rickandmorty.charactersscreen.databinding.ItemLoaderBinding

class LoaderViewHolder(binding: ItemLoaderBinding, retry: () -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    private val motionLayout: MotionLayout = binding.motionLoading

    init {
        binding.retryButton.setOnClickListener {
            retry()
        }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Loading) {
            motionLayout.transitionToEnd()
        } else {
            motionLayout.transitionToStart()
        }
    }

    companion object {
        fun getInstance(parent: ViewGroup, retry: () -> Unit): LoaderViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemLoaderBinding.inflate(inflater, parent, false)
            return LoaderViewHolder(binding, retry)
        }
    }
}
