package com.euzhene.rickandmorty.presentation.adapter

import android.view.View
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.euzhene.rickandmorty.databinding.PartialErrorBinding

class CharacterLoadStateViewHolder(
    private val binding: PartialErrorBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.btnRetry.setOnClickListener { retry.invoke() }
    }
    fun bind(loadState:LoadState) {
        binding.run {
            if (loadState is LoadState.Error) {
                tvInfo.text = loadState.error.localizedMessage
            }
             pbLoadingData.visibility = toVisibility(loadState is LoadState.Loading)
        }

    }
    private fun toVisibility(constraint:Boolean) = if (constraint) {
        View.VISIBLE
    } else {
        View.GONE
    }
}