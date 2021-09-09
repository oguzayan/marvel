package com.ayanoguz.marvel.ui.characterDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.ayanoguz.marvel.core.BaseAdapter
import com.ayanoguz.marvel.data.interactor.characterDetail.ComicsUIModel
import com.ayanoguz.marvel.databinding.ItemComicsBinding


class ComicsListAdapter(private val clickCallback: ((ComicsUIModel) -> Unit)?) :
    BaseAdapter<ComicsUIModel>(object : DiffUtil.ItemCallback<ComicsUIModel>() {
        override fun areItemsTheSame(
            oldItem: ComicsUIModel,
            newItem: ComicsUIModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ComicsUIModel,
            newItem: ComicsUIModel
        ): Boolean {
            return oldItem == newItem
        }
    }) {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val viewModel = ComicsListAdapterViewModel()
        val binding: ItemComicsBinding =
            ItemComicsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.viewModel = viewModel
        binding.rootView.setOnClickListener() {
            binding.viewModel?.item?.get()?.let { item -> clickCallback?.invoke(item) }
        }

        return binding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as ItemComicsBinding).viewModel?.item?.set(getItem(position))
        binding.executePendingBindings()
    }
}
