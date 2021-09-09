package com.ayanoguz.marvel.testUtil

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListUpdateCallback
import com.ayanoguz.marvel.data.interactor.characterList.CharacterUIModel

class NoopListCallback : ListUpdateCallback {
  override fun onChanged(position: Int, count: Int, payload: Any?) {}
  override fun onMoved(fromPosition: Int, toPosition: Int) {}
  override fun onInserted(position: Int, count: Int) {}
  override fun onRemoved(position: Int, count: Int) {}
}

class MyDiffCallback : DiffUtil.ItemCallback<CharacterUIModel>() {
  override fun areItemsTheSame(oldItem: CharacterUIModel, newItem: CharacterUIModel): Boolean {
    return oldItem == newItem
  }

  override fun areContentsTheSame(oldItem: CharacterUIModel, newItem: CharacterUIModel): Boolean {
    return oldItem == newItem
  }
}