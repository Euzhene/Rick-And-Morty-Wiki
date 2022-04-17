package com.euzhene.rickandmorty.presentation.recyclerview

import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.euzhene.rickandmorty.databinding.ActivityMainBinding
import com.euzhene.rickandmorty.databinding.PartialCharacterBinding

class CharacterViewHolder(
    val binding:PartialCharacterBinding
): RecyclerView.ViewHolder(binding.root)