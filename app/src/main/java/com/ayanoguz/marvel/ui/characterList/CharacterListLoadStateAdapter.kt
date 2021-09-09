package com.ayanoguz.marvel.ui.characterList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.ayanoguz.marvel.R

class CharacterListLoadStateAdapter(val retry: () -> Unit)  :  LoadStateAdapter<LoadStateViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ) = LoadStateViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_load_state,
            parent,
            false
        ),
        retry
    )

    override fun onBindViewHolder(
        holder: LoadStateViewHolder,
        loadState: LoadState
    ) {
        holder.bind(loadState)
    }

    override fun getStateViewType(loadState: LoadState): Int {
        return 1903
    }
}