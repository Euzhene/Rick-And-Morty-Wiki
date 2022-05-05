package com.euzhene.rickandmorty.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.euzhene.rickandmorty.R
import com.euzhene.rickandmorty.databinding.FragmentInfoBinding
import com.euzhene.rickandmorty.di.CharacterApp
import com.euzhene.rickandmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class CharacterInfoFragment : Fragment() {
    private val component by lazy {
        (requireActivity().application as CharacterApp).component.fragmentComponentFactory()
            .create(characterId)
    }

    private var _binding: FragmentInfoBinding? = null
    private val binding: FragmentInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentInfoBinding = null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CharacterInfoViewModel::class.java]
    }

    private var characterId: Int = Character.UNKNOWN_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
        component.inject(this)
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
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.characterInfo
                .catch { makeErrorToast() }
                .collectLatest {
                binding.lifecycleOwner = viewLifecycleOwner
                binding.character = it
            }
        }

    }

    private fun parseArgs() {
        characterId = requireArguments().getInt(CHARACTER_ID_ARG_KEY)
        if (characterId == Character.UNKNOWN_ID) throw RuntimeException("Character id is absent")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun makeErrorToast() {
        Toast.makeText(requireContext(), R.string.connection_failed, Toast.LENGTH_LONG).show()
    }

    companion object {
        private const val CHARACTER_ID_ARG_KEY = "character_id"

        fun newInstance(characterId:Int): CharacterInfoFragment =
            CharacterInfoFragment().apply {
                arguments = Bundle().apply {
                    putInt(CHARACTER_ID_ARG_KEY, characterId)
                }
            }
    }

}