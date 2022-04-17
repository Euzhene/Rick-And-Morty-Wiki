package com.euzhene.rickandmorty.presentation.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.paging.PagingDataAdapter
import com.euzhene.rickandmorty.databinding.PartialCharacterBinding
import com.euzhene.rickandmorty.domain.entity.Character

class CharacterAdapter :
    //LoadStateAdapter<CharacterViewHolder>()
   PagingDataAdapter<Character, CharacterViewHolder>(CharacterDiffCallback())
{
    var onItemClick: ((Character) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = PartialCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.run {
            character = item

            if (item != null) {
                root.setOnClickListener {
                    onItemClick?.invoke(item)
                }
            }
        }

    }

//    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): CharacterViewHolder {
//        val binding = PartialCharacterBinding.inflate(
//            LayoutInflater.from(parent.context),
//            parent,
//            false
//        )
//        return CharacterViewHolder(binding)
//    }
//    override fun onBindViewHolder(holder: CharacterViewHolder, loadState: LoadState) {
//        val item =  getItem(position)
//        holder.binding.run {
//            character = item
//
//            if (item != null) {
//                root.setOnClickListener {
//                    onItemClick?.invoke(item)
//                }
//            }
//        }
//    }



}