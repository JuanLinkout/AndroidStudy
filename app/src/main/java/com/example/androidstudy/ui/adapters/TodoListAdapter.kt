package com.example.androidstudy.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidstudy.data.models.TodoListItem
import com.example.androidstudy.databinding.TodoItemBinding
import com.example.androidstudy.ui.fragments.TodoListDirections

class TodoListAdapter(private val dataset: Array<TodoListItem>): RecyclerView.Adapter<TodoListAdapter.CatalogItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatalogItemViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatalogItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatalogItemViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    inner class CatalogItemViewHolder(private val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todoListItem: TodoListItem) {
            binding.textViewCatalogTitle.text = todoListItem.title
            binding.textViewCataloDescription.text = todoListItem.id.toString()
            Glide.with(binding.root).load("https://source.unsplash.com/random/600x600").into(binding.imageViewCover)

            binding.root.setOnClickListener {
                val action = TodoListDirections.todoListToTodoDetails(todoListItem)
                binding.root.findNavController().navigate(action)
            }
        }
    }
}