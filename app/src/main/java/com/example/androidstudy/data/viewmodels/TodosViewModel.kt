package com.example.androidstudy.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.androidstudy.data.models.TodoListItem
import com.example.androidstudy.data.repository.TodoRepository
import kotlinx.coroutines.launch


class TodosViewModel(private val todoRepository: TodoRepository) : ViewModel() {
    private val _todos = MutableLiveData<List<TodoListItem>>()
    val todos: LiveData<List<TodoListItem>> = _todos

    init {
        viewModelScope.launch {
            val todoList = todoRepository.getTodos()
            _todos.value = todoList
        }
    }

    companion object {
        fun Factory(): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return TodosViewModel(TodoRepository(RetrofitClient.apiService)) as T
                }
            }
        }
    }
}
