package com.example.androidstudy.ui.fragments

import com.example.androidstudy.ui.utils.StatusBarUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidstudy.data.models.TodoListItem
import com.example.androidstudy.data.viewmodels.TodosViewModel
import com.example.androidstudy.databinding.TodoListBinding
import com.example.androidstudy.ui.adapters.TodoListAdapter

class TodoList : Fragment() {
    private lateinit var binding: TodoListBinding
    private val todoViewModel by viewModels<TodosViewModel>(factoryProducer = { TodosViewModel.Factory() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TodoListBinding.inflate(layoutInflater)

        val todosObserver = Observer<List<TodoListItem>> { binding.recyclerViewCatalogList.adapter = TodoListAdapter(it.toTypedArray()) }
        todoViewModel.todos.observe(viewLifecycleOwner, todosObserver)

        val statusBarHeight = StatusBarUtil.getStatusBarHeight(binding.root.context)
        binding.recyclerViewCatalogList.setPadding(16, 16 + statusBarHeight, 16, 16)
        binding.recyclerViewCatalogList.layoutManager = LinearLayoutManager(binding.root.context)

        return binding.root
    }
}