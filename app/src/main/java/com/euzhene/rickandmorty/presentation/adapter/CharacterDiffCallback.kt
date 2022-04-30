package com.euzhene.rickandmorty.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.euzhene.rickandmorty.presentation.model.Character

class CharacterDiffCallback :
    DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
        oldItem == newItem
}