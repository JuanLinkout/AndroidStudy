package com.example.androidstudy.data.repository

import ApiService
import com.example.androidstudy.data.models.TodoListItem

class TodoRepository(private val apiService: ApiService) {
    suspend fun getTodos(): List<TodoListItem> {
        return try {
            apiService.getTodos()
        } catch (e: Exception) {
            emptyList()
        }
    }
}