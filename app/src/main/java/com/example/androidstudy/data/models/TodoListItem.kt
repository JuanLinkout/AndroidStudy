package com.example.androidstudy.data.models

import java.io.Serializable

data class TodoListItem(
    val userId: Number,
    val id: Number,
    val title: String,
    val completed: Boolean
) : Serializable
