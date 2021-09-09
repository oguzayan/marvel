package com.ayanoguz.marvel.ui.characterDetail


import android.util.Log
import androidx.navigation.fragment.navArgs
import com.ayanoguz.marvel.R
import com.ayanoguz.marvel.core.BaseFragment
import com.ayanoguz.marvel.data.interactor.characterDetail.ComicsUIModel
import com.ayanoguz.marvel.databinding.FragmentCharacterDetailBinding
import com.ayanoguz.marvel.util.UIState
import com.ayanoguz.marvel.util.extensions.dismissProgressDialog
import com.ayanoguz.marvel.util.extensions.observeWith
import com.ayanoguz.marvel.util.extensions.showProgressDialog
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class CharacterDetailFragment :
    BaseFragment<CharacterDetailViewModel, FragmentCharacterDetailBinding>(CharacterDetailViewModel::class.java) {

    val args: CharacterDetailFragmentArgs by navArgs()


    override fun onInit() {
        initArgs()
        setListener()
        initObserver()
        getCharacterDetail()
    }

    private fun initArgs() {
        binding?.viewModel?.characterItem?.set(args.characterItem)
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_character_detail
    }

    private fun setListener() {

    }

    private fun initObserver() {
        binding?.viewModel?.liveComicsResult?.observeWith(viewLifecycleOwner) {
            when (it) {
                UIState.Loading -> {
                    binding?.viewModel?.progressLiveData?.postValue(true)

                }
                is UIState.Error -> {
                    //showError
                }
                is UIState.Data -> {
                    binding?.viewModel?.progressLiveData?.postValue(false)
                    binding?.viewModel?.showEmptyView?.set(it.data.isEmpty())
                    initAdapter(it.data)

                }
            }
        }
        binding?.viewModel?.progressLiveData?.observeWith(viewLifecycleOwner) {
            if (it) showProgressDialog() else dismissProgressDialog()
        }
    }

    private fun initAdapter(list: List<ComicsUIModel>) {
        val adapter = ComicsListAdapter() {

        }
        binding?.comicsRecycler?.adapter = adapter
        (binding?.comicsRecycler?.adapter as ComicsListAdapter).submitList(list)

    }

    private fun getCharacterDetail() {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val date = Date()
        val todayString = sdf.format(date)


        binding?.viewModel?.getCharacterDetail(
            args.characterItem.id ?: 0,
            10,
            "2005-01-01,$todayString",
            "-onsaleDate"

        )
    }


}