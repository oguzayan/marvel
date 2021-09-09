package com.ayanoguz.marvel.ui.characterList


import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.ayanoguz.marvel.R
import com.ayanoguz.marvel.core.BaseFragment
import com.ayanoguz.marvel.databinding.FragmentCharacterListBinding
import com.ayanoguz.marvel.util.ConnectionUtil
import com.ayanoguz.marvel.util.extensions.observeWith
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterListFragment :
    BaseFragment<CharacterListViewModel, FragmentCharacterListBinding>(CharacterListViewModel::class.java) {
    lateinit var connectionUtil: ConnectionUtil

    override fun onInit() {
        connectionUtil = ConnectionUtil.getInstance(requireContext())
        connectionUtil.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    initAdapter()
                    binding?.errorText?.visibility = View.GONE
                    binding?.swipeRefresh?.visibility = View.VISIBLE
                    connectionUtil.removeObservers(viewLifecycleOwner)
                } else {
                    binding?.errorText?.visibility = View.VISIBLE
                    binding?.swipeRefresh?.visibility = View.GONE
                }
            }
        )
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_character_list
    }

    private fun initAdapter() {
        binding?.viewModel?.getCharacterList()
        binding?.characterRecycler?.layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = CharacterAdapter {
            val action =
                CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailFragment(
                    it
                )
            findNavController().navigate(action)
        }
        binding?.characterRecycler?.adapter = adapter.withLoadStateFooter(
            CharacterListLoadStateAdapter {
                adapter.retry()
            }
        )

        lifecycleScope.launchWhenCreated {
            adapter.loadStateFlow.collectLatest { loadStates ->
                binding?.swipeRefresh?.isRefreshing = loadStates.refresh is LoadState.Loading
            }
        }

        (binding?.characterRecycler?.layoutManager as? GridLayoutManager)?.spanSizeLookup =
            object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when {
                        (binding?.characterRecycler?.adapter as? ConcatAdapter)?.getItemViewType(
                            position
                        ) == 0 -> 1
                        else -> 2
                    }
                }
            }

        binding?.viewModel?.liveCharacterResult?.observeWith(viewLifecycleOwner)
        {
            lifecycleScope.launch {
                adapter.submitData(it)
                binding?.viewModel?.progressLiveData?.postValue(false)
            }
        }
    }
}