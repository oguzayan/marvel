package com.ayanoguz.marvel.ui.characterList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ayanoguz.marvel.data.interactor.characterList.CharacterUIModel
import com.ayanoguz.marvel.databinding.ItemCharacterBinding

class CharacterAdapter(private val clickCallback: ((CharacterUIModel) -> Unit)?) :
    PagingDataAdapter<CharacterUIModel, CharacterAdapter.ViewHolder>(object :
        DiffUtil.ItemCallback<CharacterUIModel>() {
        override fun areItemsTheSame(
            oldItem: CharacterUIModel,
            newItem: CharacterUIModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CharacterUIModel,
            newItem: CharacterUIModel
        ): Boolean {
            return oldItem == newItem
        }

    }) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel?.item?.set(getItem(position))
        holder.binding.rootView.setOnClickListener {
            holder.binding.viewModel?.item?.get()?.let { item -> clickCallback?.invoke(item) }
        }
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewModel = CharacterAdapterViewModel()
        return ViewHolder(ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
            .apply {
                this.viewModel = viewModel
            }
        )
    }

    class ViewHolder(val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root)
}