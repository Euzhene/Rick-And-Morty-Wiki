package com.euzhene.rickandmorty.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.euzhene.rickandmorty.databinding.FragmentInfoBinding
import com.euzhene.rickandmorty.domain.model.Character

class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding: FragmentInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentInfoBinding = null")

    private lateinit var character: Character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.character = character
    }

    private fun parseArgs() {
        val args = requireArguments()
        if (!args.containsKey(CHARACTER_ARG_KEY)) {
            throw RuntimeException("param character is absent")
        }
        character = args.getParcelable(CHARACTER_ARG_KEY)
            ?: throw RuntimeException("param character is null")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val CHARACTER_ARG_KEY = "character"

        fun newInstance(character: Character): InfoFragment =
            InfoFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(CHARACTER_ARG_KEY, character)
                }
            }
    }
}