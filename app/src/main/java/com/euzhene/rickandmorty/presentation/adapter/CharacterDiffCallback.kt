package com.euzhene.rickandmorty.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.euzhene.rickandmorty.domain.entity.Character

class CharacterDiffCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.name == newItem.name && oldItem.image == newItem.image &&
                oldItem.gender == newItem.gender && oldItem.episode == newItem.episode
    }
}