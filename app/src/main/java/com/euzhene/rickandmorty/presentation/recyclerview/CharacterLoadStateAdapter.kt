package com.euzhene.rickandmorty.presentation.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.euzhene.rickandmorty.databinding.PartialErrorBinding

class CharacterLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<CharacterLoadStateViewHolder>() {

    override fun onBindViewHolder(holder: CharacterLoadStateViewHolder, loadState: LoadState) {
        Log.d("ViewHolder", "bind: ")
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): CharacterLoadStateViewHolder {
        Log.d("ViewHolder", "bind: ")

        val binding = PartialErrorBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterLoadStateViewHolder(binding, retry)
    }
}