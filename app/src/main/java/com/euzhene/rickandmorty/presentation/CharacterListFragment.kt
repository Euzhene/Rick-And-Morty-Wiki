package com.euzhene.rickandmorty.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.ConcatAdapter
import com.euzhene.rickandmorty.R
import com.euzhene.rickandmorty.databinding.FragmentCharacterListBinding
import com.euzhene.rickandmorty.di.CharacterApp
import com.euzhene.rickandmorty.presentation.adapter.CharacterAdapter
import com.euzhene.rickandmorty.presentation.adapter.CharacterLoadStateAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


class CharacterListFragment : Fragment() {
    private val component by lazy {
        (requireActivity().application as CharacterApp).component
    }

    private var _binding: FragmentCharacterListBinding? = null
    private val binding: FragmentCharacterListBinding
        get() = _binding ?: throw RuntimeException("FragmentCharacterListBinding = null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CharacterViewModel::class.java]
    }

    private val pagingAdapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        component.inject(this)
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        setupAdapter()
        subscribeToSource()
        setupClickListener()
    }

    private fun setupAdapter() {
        val callback: () -> Unit = {
            pagingAdapter.retry()
        }
        val adapters = pagingAdapter.withLoadStateHeaderAndFooter(
            CharacterLoadStateAdapter(callback),
            CharacterLoadStateAdapter(callback)
        )
        val concatenated = ConcatAdapter(pagingAdapter, adapters)
        binding.recyclerView.adapter = concatenated

        setConnectionStateListener()


    }

    private fun setConnectionStateListener() {
        with(binding) {
            btnRetry.setOnClickListener {
                pagingAdapter.retry()
            }
            pagingAdapter.addLoadStateListener { loadState ->
                loadState.source.refresh.run {
                    if (this is LoadState.Error) {
                        tvInfo.text = this.error.localizedMessage
                    } else if (this is LoadState.Loading) {
                        tvInfo.text = getString(R.string.loading_data)
                    }
                    pbLoadingData.visibility = toVisibility(this is LoadState.Loading)
                    tvInfo.visibility = toVisibility(this !is LoadState.NotLoading)
                    btnRetry.visibility = toVisibility(this is LoadState.Error)
                    recyclerView.visibility = toVisibility(this is LoadState.NotLoading)
                }
            }
        }
    }


    private fun toVisibility(constraint: Boolean) = if (constraint) {
        View.VISIBLE
    } else {
        View.GONE
    }

    private fun subscribeToSource() {
        lifecycleScope.launch {
            viewModel.charactersFlow.collectLatest {
                pagingAdapter.submitData(it)
            }
        }
    }

    private fun setupClickListener() {
        pagingAdapter.onItemClick = {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, InfoFragment.newInstance(it))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}